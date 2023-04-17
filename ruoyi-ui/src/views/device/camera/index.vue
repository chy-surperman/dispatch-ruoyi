<template>
  <el-card class="main-card">
    <div class="title">{{ this.$route.name }}</div>
    <!--      状态选择栏-->
    <div class="operation-container">
      <el-button
        type="danger"
        size="small"
        icon="el-icon-delete"
        :disabled="cameraIds.length === 0"
        @click="remove = true">
        批量删除
      </el-button>
      <el-button
        type="success"
        size="small"
        icon="el-icon-download"
        :disabled="cameraIds.length===0"
        @click="isExport = true">
        批量导出
      </el-button>
      <el-button
        type="primary"
        size="small"
        icon="el-icon-plus"
        @click="drawer = true">
        新增记录
      </el-button>
      <!--        搜索栏-->
      <div style="margin-left: auto">
        <el-tooltip content="暂不进行内容筛选" placement="top" effect="light">
          <el-select
            clearable
            size="small"
            v-model="companyName"
            filterable
            placeholder="请选择公司"
            style="margin-right: 1rem; width: 180px"
            @change="listRouteName">
            <el-option label="全部" value="" />
            <el-option v-for="item in companies"  :value="item" />
          </el-select>
        </el-tooltip>

        <el-select
          clearable
          size="small"
          v-model="routeName"
          filterable
          placeholder="请选择线路"
          style="margin-right: 1rem; width: 180px"
          @keyup.enter.native="searchCamera">
          <el-option label="全部" value="" @click="companyName=''"/>
          <el-option v-for="item in routeNames" :value="item.routeName" @click.native="companyName=item.company"/>
        </el-select>
        <el-input
          clearable
          v-model="keywords"
          prefix-icon="el-icon-search"
          size="small"
          placeholder="请输入线路名或自编号"
          style="width: 200px"
          @keyup.enter.native="searchCamera" />
        <el-button type="primary" size="small" icon="el-icon-search" style="margin-left: 1rem" @click="searchCamera">
          搜索
        </el-button>
      </div>
    </div>
    <!--      表格主体-->
    <el-table border :data="cameras" v-loading="loading" @selection-change="selectionChange"  :header-cell-style="{background:'#FFFFFF'}">
      <el-table-column type="selection" width="55" />

      <el-table-column prop="showDate" label="上报时间" width="200" align="center">
        <template slot-scope="scope">
          <i class="el-icon-time" style="margin-right: 5px" />
          {{ scope.row.showDate}}
        </template>
      </el-table-column>

      <el-table-column prop="selfNum,routeName" label="线路/自编号" width="150" align="center">
        <template slot-scope="scope">
          {{scope.row.routeName}}<span style="color: #ff9900;margin: 3px">|</span>{{scope.row.selfNum}}
        </template>
      </el-table-column>

      <el-table-column prop="plateNum" label="车牌" width="150" align="center">
        <template slot-scope="scope">
          {{scope.row.plateNum}}
        </template>
      </el-table-column>

      <el-table-column prop="deviceId" label="终端编号" width="250" align="center">
        <template slot-scope="scope">
          <i class="el-icon-cpu" style="color: #1ab394;margin-right: 0.5rem"></i>{{scope.row.deviceId}}
        </template>
      </el-table-column>

      <el-table-column prop="iccid" label="ICCID" align="center">
        <template slot-scope="scope">
          {{scope.row.iccid}}
        </template>
      </el-table-column>

      <el-table-column prop="currentDeviceVersion" label="当前版本" width="150" align="center">
        <template slot-scope="scope">
          {{scope.row.currentDeviceVersion}}
        </template>
      </el-table-column>

      <el-table-column prop="volume" label="屏幕亮度" width="100" align="center">
        <template slot-scope="scope">
          <i class="el-icon-sunny" style="color: #1ab394;margin-right: 0.5rem"></i>{{scope.row.volume}}
        </template>
      </el-table-column>

      <el-table-column prop="screenBrightness" label="声音大小" width="100" align="center">
        <template slot-scope="scope">
          {{scope.row.screenBrightness}}
        </template>
      </el-table-column>

      <el-table-column prop="cameraList" label="摄像头编号" width="200" align="center">
        <template slot-scope="scope">
          <span v-for="item in scope.row.cameraList" style="font-family: maoken;color: #1ab394;display: flex;margin: auto 20%"><i class="el-icon-video-camera" style="color: black;margin-right: 0.5rem;align-self: center;"/>{{item}}</span>
        </template>
      </el-table-column>

    </el-table>
    <!--      分页插件-->
    <el-pagination
      class="pagination-container"
      background
      @size-change="sizeChange"
      @current-change="currentChange"
      :current-page="current"
      :page-size="size"
      :total="count"
      :page-sizes="[5, 10, 20,count]"
      layout="total, sizes, prev, pager, next, jumper" />

    <el-drawer
      title="新增记录"
      :visible.sync="drawer"
      size="18%"
      direction="ttb"
      @closed="formClosed"
      :before-close="handleClose">
      <el-form ref="cameraForm" :model="form" label-width="80px" label-position="right" :inline="true" :rules="rules">
        <el-form-item label="终端编号" label-width="5rem" prop="deviceId" required>
          <el-input v-model="form.deviceId" placeholder="请输入终端编号" autocomplete="off" style="width: 14rem"></el-input>
        </el-form-item>
        <el-form-item label="上报时间" label-width="5rem">
          <el-date-picker
            v-model="form.showDate"
            type="datetime"
            placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="摄像头编号" label-width="6rem" prop="cameraList">
          <el-input v-model="form.cameraList" placeholder="请输入摄像头编号，使用','分隔" autocomplete="off" style="width: 20rem"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="drawer=false">取消</el-button>
          <el-button type="primary" @click="onSubmit">创建</el-button>
        </el-form-item>
      </el-form>
    </el-drawer>
    <el-dialog :visible.sync="isExport" width="30%">
      <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" /><span style="font-family: maoken;color: brown">提示</span></div>
      <div style="font-size: 1rem;font-family: maoken">是否导出选中选中项？</div>
      <div slot="footer">
        <el-button @click="isExport = false">取 消</el-button>
        <el-button type="primary" @click="exportBreakdowns()"> 确 定 </el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
import {ListCompanyName, ListRouteName, ListRouteNameForCompany} from "@/api/device/dict/data"
import {ListCamera, OnSubmit} from "@/api/device/camera";
export default {
  components:{

  },
  created() {
    this.listCompany();
    this.listRouteName();
    this.listCamera()
  },
  data: function () {
    return {
      cameras:[],
      cameraList:[],
      current:1,
      size:10,
      count:0,
      companies:[],
      companyName:null,
      routeNames:[],
      routeName:null,
      selfNums:null,
      keywords: null,
      flushes:1,
      drawer:false,
      form:{},
      cameraIds:[],
      loading:false,
      isExport:false,
      rules:{
        deviceId:[{ required: true,message:'请输入终端编号',trigger: 'blur' }],
        cameraList:[{ required: true,message:'请输入摄像头编号，使用\',\'分隔',trigger: 'blur' }]
      },

    }
  },
  methods: {
    selectionChange(cameras){
      this.cameraIds=[]
      for(let i of cameras){
        this.cameraIds.push(i.id)
      }
    },
    //查询公司列表new
    listCompany(){
      ListCompanyName().then(response =>{
        this.companies=response.data
      })
    },
    //查询线路列表new
    listRouteName(){
      if(this.companyName==null||this.companyName===""){
        ListRouteName().then(response => {
          this.routeNames=response.data
        })
      }else {
        this.routeName=""
        let query={
          company:this.companyName
        }
        ListRouteNameForCompany(query).then(response => {
          this.routeNames=response.data
        }).catch(error =>{
          if(this.flushes<=1){
            this.listRouteName()
            this.flushes++
          }
        })
      }
    },
    //查询摄像头列表
    listCamera(){
      this.loading=true
      let query={
        pageSize:this.size,
        pageNum:this.current,
        routeName:this.routeName,
        searchValue:this.keywords,
      }
      console.log(query)
      ListCamera(query).then(response => {
        this.cameras=response.rows
        for(let i of this.cameras){
          // i.showDate=i.showDate.replace(/["T"]/," ")
          // i.showDate=i.showDate.replace(".000+08:00","")
          // i.cameraList=i.cameraList.replace(/[\[\\"\]]/g,"")
          i.showDate=new Date(i.showDate).toLocaleString()
          i.cameraList=i.cameraList.split(",")
          this.loading=false
        }
        this.count=response.total
      })
    },
    //条件查询
    searchCamera(){
      this.current=1
      this.listCamera()
    },
    //分页显示条数
    sizeChange(size){
      this.size=size
      this.listCamera()
    },
    //页码跳转
    currentChange(current){
      this.current=current
      this.listCamera()
    },
    //误关闭确认
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    //表单关闭后回调
    formClosed(){
      this.$refs.cameraForm.resetFields()
    },
    //提交表单
    onSubmit(){
      this.$refs.cameraForm.validate((valid) =>{
        if (valid){
          this.form.cameraList=this.form.cameraList.replace(/["，"]/g,",")
          console.log(this.form.cameraList)
          // OnSubmit(this.form).then( _=>{
          //   this.$message({
          //     message:"提交成功",
          //     type:"success"
          //   })
          // }).catch( _=> {
          //   this.$message.error("创建失败")
          // })
        }else {
          return false
        }
      })
    },
    //导出选中项
    exportBreakdowns() {
      this.download('/device/cameraList/export',{
        ids:this.cameraIds
      },`${new Date().getTime()}.xlsx`)
      // this.isExport=false
    },
  },
  watch: {

  },
  computed: {

    },
}
</script>

<style scoped>
.main-card {
  min-height: calc(100vh - 126px);
  margin-top: 1rem;
  margin-left: 1rem;
}
.operation-container {
  margin-top: 2rem;
  display: flex;
  margin-bottom: 1.5rem;
}
.article-status-menu {
  font-size: 14px;
  margin-top: 40px;
  color: #999;
  margin-bottom: 1.5rem;
}
.article-status-menu span {
  margin-right: 24px;
}
.status {
  cursor: pointer;
}
.active-status {
  cursor: pointer;
  color: #333;
  font-weight: bold;
}
.article-cover {
  position: relative;
  width: 100%;
  height: 90px;
  border-radius: 4px;
}
.article-cover::after {
  content: '';
  background: rgba(0, 0, 0, 0.3);
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.article-status-icon {
  color: #fff;
  font-size: 1.5rem;
  position: absolute;
  right: 1rem;
  bottom: 1.4rem;
}
.title {
  position: absolute;
  left: 1rem;
  font-size: 16px;
  font-weight: bold;
  color: #202a34;
}
.title::before {
  content: '';
  width: 24px;
  height: 16px;
  border-left: 3px solid #0081ff;
  margin-right: 20px;
}
.pagination-container{
  float: right;
  margin-bottom: 1.5rem;
}
/deep/.el-drawer__header {
  color: rgb(3,109,107);
  font-size: 18px;
  font-family: maoken;
}
</style>

