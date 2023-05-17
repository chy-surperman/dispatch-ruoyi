<template>
  <el-card class="main-card">
    <div class="title">{{ this.$route.name }}</div>

    <div class="view">
      <!--      车辆菜单-->
      <div class="vehicle-tree">
        <!--      搜索栏-->
        <div class="search">
        <span style="display: flex;margin: 1rem;">
        <el-input placeholder="请输入车辆信息" v-model="search" @keyup.native.enter="searchVehicle"></el-input>
        <el-button type="primary" icon="el-icon-search" circle style="margin: 0 1rem 0 1rem" @click="searchVehicle" ></el-button>
          </span>
        </div>
        <div class="tree">
          <el-tree
            ref="tree"
            :data="treeView"
            :props="props"
            :load="loadNode"
            :default-expanded-keys="keys"
            node-key="id"
            lazy
            accordion
            show-checkbox
            highlight-current
            @check="checkIds">
          </el-tree>
        </div>
      </div>

      <!--      功能窗-->
      <div class="fun-view">
        <div class="funDetails">
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=201;title='打开GPS上报';isExport=true">打开GPS上报</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=206;title='打开报站';isExport=true">打开报站</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=208;title='站点更新';isExport=true">站点更新</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=211;title='语音更新';isExport=true">语音更新</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=20;title='测试喇叭';isExport=true">测试喇叭</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=31;title='程序下载';isExport=true">程序下载</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=32;title='版本上报';isExport=true">版本上报</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=15;title='调整音量';isExport=true">调整音量</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=13;title='重启程序';isExport=true">重启程序</el-button>
          <el-button type="primary" :disabled='vehicleIds.length===0' @click="commandQuery.type=14;title='屏幕亮度';isExport=true">屏幕亮度</el-button>
        </div>
        <div class="vehicleDetails">
          <el-table
            :data="tableData"
            border
            style="height: 100%;width: 100%;overflow: auto" @selection-change="selectionChange" :header-cell-style="{background:'#FFFFFF'}">
            <el-table-column type="selection"/>
            <el-table-column
              prop="selfNum,plateNum"
              label="车辆">
              <template slot-scope="scope">
                {{scope.row.selfNum}}<span style="color: #ff9900;margin: 3px">|</span>{{scope.row.plateNum}}
              </template>
            </el-table-column>
            <el-table-column
              prop="deviceId"
              label="设备ID">
            </el-table-column>
            <el-table-column
              prop="iccid"
              label="ICCID">
            </el-table-column>
            <el-table-column
              prop="currentDeviceVersion"
              label="当前版本">
            </el-table-column>
            <el-table-column
              prop="lastVersion"
              label="最后版本">
            </el-table-column>
            <el-table-column
              prop="screenBrightness"
              label="屏幕亮度">
            </el-table-column>
            <el-table-column
              prop="volume"
              label="音量大小">
            </el-table-column>
          </el-table>
        </div>
      </div>
    </div>

    <el-dialog :visible.sync="isExport" width="30%">
      <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" /><span style="font-family: maoken;color: brown">提示</span></div>
      <div style="font-size: 1rem;font-family: maoken">确认{{title}}</div>
      <div slot="footer">
        <el-button @click="isExport = false">取 消</el-button>
        <el-button type="primary" @click="command()"> 确 定 </el-button>
      </div>
    </el-dialog>
  </el-card>
</template>
<script>
import {Command, PickVehicle} from "@/api/device/hostInformation";
import {ListRouteNameForCompany, SelfNum} from "@/api/device/dict/data";

export default {
  data() {
    return {
      search: null,
      vehicleIds:[],
      treeView:[],
      keys:[],
      commandQuery:{
        deviceId:'',
        type:'',
      },
      isExport:false,
      title:'',

      props: {
        label: 'label',
        children: 'children',
        isLeaf: 'leaf',
        id:'000'
      },
      count: 1,
      tableData: [],
      query: {
        company:"通畅巴士",
        selfNum:"",
      }
    };
  },
  created() {
    this.pickVehicle()
  },
  methods: {
    selectionChange(vehicle) {
      this.vehicleIds = []
      for (let i of vehicle) {
        this.vehicleIds.push(i.selfNum)
      }
      console.log(this.vehicleIds)
    },
    command() {
      for(let i of this.vehicleIds) {
        query.deviceId = i
        // Command(query).then(response => {
        //
        // })
      }
    },
    loadNode(node, resolve) {
      let query = {routeName:node.label}
      let leaf = []
      if(node.label!=null){
        SelfNum(query).then(response => {
          for(let i of response.data){
            let model =JSON.parse(JSON.stringify(this.treeView))
            model.label=i.selfNum+" ("+i.plateNum+")"
            model.children=null
            model.leaf=true
            model.id=i.selfNum
            leaf.push(model)
          }
          return resolve(leaf)
        })
      }
    },

    // limitFre(){
    //   let i=1
    //   console.log(i)
    //   if(i===1){
    //     this.checkIds()
    //   }
    //   i+=1
    //
    // },

    checkIds(){
      this.tableData = []
      let ids = this.$refs.tree.getCheckedNodes()
      console.log(ids)
      let query = {
        routeName: '',
        selfNum:''
      }
      let of = true
      for(let i of ids){
        if(i.children!=null){
          this.keys.push(i.label)
          query.routeName=i.label
          // PickVehicle(query).then(response => {
          //   for (let i of response.rows){
              // this.tableData.push(i)
          //   }
          // })
          // of =false
        }
        if(of && Array.prototype.isPrototypeOf(i)){
        let numVehicle = i.label
          let num = numVehicle.indexOf(' ')
          // console.log(str)
        query.selfNum=numVehicle.substring(0, num)
          PickVehicle(query).then(response => {
            for (let i of response.rows){
              this.tableData.push(i)
            }
          })
        }
      }
    },

    searchVehicle(){
      if(this.search==null){
        return
      }
      this.tableData=[]
      let query = {
        selfNum:this.search
      }
      this.keys=[]
      PickVehicle(query).then(response => {
        for (let i of response.rows){
          this.keys.push(i.routeName)
          this.tableData.push(i)
        }
      })
      this.$refs.tree.setCheckedNodes([{
        label:this.search
      }])
      this.$refs.tree.setCheckedKeys([this.search]);
    },

    pickVehicle() {
      // 按类型为String的属性排序
      function sortByStr (array, key) {
        return array.sort(function (b, a) {
          var x = (a[key].substr(0, 1)).charCodeAt()
          var y = (b[key].substr(0, 1)).charCodeAt()
          return x - y
        })
      }
      let tree = []
      ListRouteNameForCompany(this.query).then(response=>{
        for(let i of response.data){
          let module =JSON.parse(JSON.stringify(this.props))
          module.label=i.routeName
          module.id=i.routeName
          tree.push(module)
        }
        this.treeView = sortByStr(tree,"label")
      })
    }
  }
}
</script>

<style lang="scss">
.main-card {
  min-height: calc(100vh - 126px);
  margin-top: 1rem;
  margin-left: 1rem;

  .title {
    position: absolute;
    left: 1rem;
    font-size: 16px;
    font-weight: bold;
    color: #202a34;
    margin-bottom: 1rem;
  }

  .title::before {
    content: '';
    width: 24px;
    height: 16px;
    border-left: 3px solid #0081ff;
    margin-right: 20px;
  }

  .view {
    margin-top: 2rem;
    height: 49em;
    border: 1px white solid;
    display: flex;
    justify-content: space-between;

    .vehicle-tree {
      height: 100%;
      width: 20%;
      border: 1px silver solid;
      min-width: 10rem;
      //overflow: auto;
      .search {
        height: 10%;
        border: 1px white solid;
      }
      .tree {
        height: 89%;
        margin:0 1rem 0 1rem;
        overflow: auto;
      }
    }

    .fun-view {
      height: 100%;
      width: 79%;
      justify-content: flex-end;
      border: 1px silver solid;

      .funDetails {
        height: auto;
        padding: 1rem;
        display: flex;
        flex-wrap: wrap;
        align-items: flex-start;
        //align-content: flex-start;
        //flex-direction: column;
        :first-child {
          margin-left: 10px;
        }
        >button{
          margin-bottom: 3px;
          text-align: center;
        }
      }

      .vehicleDetails {
        height: 89%;
        margin-left: 2%;
        width: 96%;
        overflow: auto;
      }
    }
  }

}
</style>
