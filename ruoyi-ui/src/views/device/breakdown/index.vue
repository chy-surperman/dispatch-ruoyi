<template>
    <el-card class="main-card">
      <div class="title">{{ this.$route.name }}</div>
<!--      状态选择栏-->
      <div class="article-status-menu">
        <span>状态</span>
        <span @click="changeStatus('all')" :class="isActive('all')">全部</span>
        <span @click="changeStatus('未维护')" :class="isActive('未维护')"> 未维护 </span>
        <span @click="changeStatus('已维护')" :class="isActive('已维护')"> 已维护 </span>
      </div>
<!--      功能栏-->
      <div class="operation-container">
        <el-button
          type="danger"
          size="small"
          icon="el-icon-delete"
          :disabled="breakdownIds.length === 0"
          @click="remove = true">
          批量删除
        </el-button>
        <el-button
          type="success"
          size="small"
          icon="el-icon-download"
          :disabled="breakdownIds.length === 0"
          @click="isExport = true">
          批量导出
        </el-button>
        <el-button
          type="primary"
          size="small"
          icon="el-icon-plus"
          @click="dialogForFrom=true">
          新增故障
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
            @keyup.enter.native="searchBreakdown">
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
            @keyup.enter.native="searchBreakdown" />
          <el-button type="primary" size="small" icon="el-icon-search" style="margin-left: 1rem" @click="searchBreakdown">
            搜索
          </el-button>
        </div>
      </div>
<!--      表格主体-->
      <el-table border :data="breakdowns" @selection-change="selectionChange" v-loading="loading" :header-cell-style="{background:'#FFFFFF'}">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="url" label="故障图片" width="180" align="center">
          <template slot-scope="scope">
            <el-image
              class="article-cover"
              fit="cover"
              ref="breakdownImg"
              :preview-src-list="imageList"
              @click.native="doPreviewImg(scope.row.url,0)"
              lazy
              :src="
              scope.row.url
                ? scope.row.url
                : 'https://p4.itc.cn/images01/20200814/0e262c44bd9c4c8fb7bd9e13c0683447.jpeg'
            "></el-image>
          </template>
        </el-table-column>

        <el-table-column prop="reportTime" label="上报时间" width="130" align="center">
          <template slot-scope="scope">
            <i class="el-icon-time" style="margin-right: 5px" />
            {{ scope.row.reportTime}}
          </template>
        </el-table-column>

        <el-table-column prop="description" label="故障描述" align="center">
          <template slot-scope="scope">
            {{scope.row.description}}
            <div v-if="scope.row.description===''||scope.row.description==null" style="font-size: 20px">
              <el-tooltip content="未上传" placement="top" effect="light">
                <i class="el-icon-document-delete"></i>
              </el-tooltip>
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="mainUrl" label="维护图片" width="180" align="center">
          <template slot-scope="scope">
            <el-image
              class="article-cover"
              fit="cover"
              ref="maintainImg"
              :preview-src-list="imageList"
              @click.native="doPreviewImg(scope.row.mainUrl,1)"
              lazy
              :src="
              scope.row.mainUrl
                ? scope.row.mainUrl
                : 'https://p4.itc.cn/images01/20200814/0e262c44bd9c4c8fb7bd9e13c0683447.jpeg'"
              />
          </template>
        </el-table-column>

        <el-table-column prop="maintainTime" label="维护时间" width="130" align="center">
          <template slot-scope="scope">
            <i class="el-icon-time" style="margin-right: 5px" />
            {{ scope.row.maintainTime}}
          </template>
        </el-table-column>

        <el-table-column prop="selfNum,routeName" label="线路/自编号" width="150" align="center">
          <template slot-scope="scope">
            {{scope.row.routeName}}/{{scope.row.selfNum}}
          </template>
        </el-table-column>
        <el-table-column prop="maintainDescription" label="维护说明" width="170" align="center">
          <template slot-scope="scope">
            {{scope.row.maintainDescription}}
            <div v-if="scope.row.maintainDescription===''||scope.row.maintainDescription==null" style="font-size: 20px">
              <el-tooltip content="暂无" placement="top" effect="light">
                <i class="el-icon-document-delete"></i>
              </el-tooltip>
            </div>
          </template>
        </el-table-column>

        <el-table-column prop="status" label="维护状态" width="90" align="center">
          <template slot-scope="scope">
          <span v-if="scope.row.status===0">
            <el-tag type="danger">未维护</el-tag>
          </span>
            <span v-else>
              <el-tag type="success">已维护</el-tag>
            </span>
          </template>
        </el-table-column>
        <el-table-column prop="type" label="故障类型" width="100" align="center">
          <template slot-scope="scope">
            <el-tag :type="breakdownType(scope.row.type).tagType">
              {{breakdownType(scope.row.type).name }}
            </el-tag>
          </template>
        </el-table-column>

        <el-table-column prop="phone" label="司机" width="80" align="center">
          <template slot-scope="scope">
            <el-tooltip  placement="top" effect="light">
              <span slot="content">{{scope.row.phone}}</span>
              <el-tag class="el-icon-phone-outline"></el-tag>
            </el-tooltip>
          </template>
        </el-table-column>

        <el-table-column label="操作" align="center" width="150">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" @click="editBreakdown(scope.row.id)">
              编辑
            </el-button>
            <el-popconfirm
              title="确定删除吗？"
              style="margin-left: 10px"
              @confirm="deleteBreakdown(scope.row.id)"
              >
              <el-button size="mini" type="danger" slot="reference"> 删除 </el-button>
            </el-popconfirm>
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
      <el-dialog :visible.sync="remove" width="25%">
        <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" /><span style="font-family: maoken;color: brown">注意</span></div>
        <div style="font-size: 1rem;font-family: maoken">是否彻底删除选中项？</div>
        <div slot="footer">
          <el-button @click="remove = false">取 消</el-button>
          <el-button type="primary" @click="deleteBreakdown(null)"> 确 定 </el-button>
        </div>
      </el-dialog>
      <el-dialog :visible.sync="isExport" width="30%">
        <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" /><span style="font-family: maoken;color: brown">提示</span></div>
        <div style="font-size: 1rem;font-family: maoken">是否导出选中文章？</div>
        <div slot="footer">
          <el-button @click="isExport = false">取 消</el-button>
          <el-button type="primary" @click="exportBreakdowns()"> 确 定 </el-button>
        </div>
      </el-dialog>
<!--      提交表单-->
      <el-drawer
        title="新增故障"
        :before-close="handleClose"
        :visible.sync="dialogForFrom"
        @closed="closedForm"
        direction="rtl"
        custom-class="from_drawer"
        ref="drawer"
      >
        <div class="drawer__content">
          <el-form ref="form" :model="form" label-width="80px" label-position="right" :rules="formRules">
            <el-form-item label="故障描述">
              <el-input
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="form.description"
                style="width: 23rem">
              </el-input>
            </el-form-item>
            <el-form-item label="故障类型" >
              <el-select v-model="form.type" placeholder="请选择故障类型" style="width: 14rem">
                <el-option v-for="item in type" :label="item.name" :value="item.value"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="线路名" required>
              <el-col :span="8">
                <el-form-item prop="routeName">
                <el-select placeholder="选择线路名" v-model="form.routeName" filterable style="width: 100%;">
                  <el-option v-for="item in routeNames" :value="item.routeName"></el-option>
                </el-select>
                </el-form-item>
              </el-col>
              <el-col class="line" :span="3" style="margin-left: 0.5rem">-自编号</el-col>
              <el-col :span="8">
                <el-form-item prop="selfNum">
                <el-select placeholder="选择自编号" v-model="form.selfNum" filterable style="width: 100%;">
                  <el-option v-for="item in selfNums" :value="item.selfNum"></el-option>
                </el-select>
                </el-form-item>
              </el-col>
            </el-form-item>
            <el-form-item label="司机手机">
              <el-input placeholder="请输入手机号" v-model="form.phone" style="width: 14rem"  maxlength="11"></el-input>
            </el-form-item>
            <el-form-item label="上报时间">
              <el-date-picker
                v-model="form.reportTime"
                type="datetime"
                placeholder="选择日期时间"
                style="width: 14rem">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="维护状态">
              <el-tooltip :content="form.status>0?'已维护':'未维护'" placement="right" effect="light">
                <el-switch v-model="form.status" active-value='1' inactive-value='0'></el-switch>
              </el-tooltip>
            </el-form-item>
            <el-form-item label="维护时间">
              <el-date-picker
                v-model="form.maintainTime"
                type="datetime"
                placeholder="选择日期时间"
                style="width: 14rem">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="故障图片">
              <ImageUpload ref="breakImage" @input="breakImage" :value="form.url">
              </ImageUpload>
            </el-form-item>
            <el-form-item label="维护图片">
              <ImageUpload ref="mainImage" @input="mainImage" :value="form.mainUrl">
              </ImageUpload>
            </el-form-item>
            <el-form-item label="维护说明">
              <el-input
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="form.maintainDescription"
                style="width: 23rem"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit()" :loading="loadingForFrom">{{loadingForFrom ? '保存中' : '保存'}}</el-button>
              <el-button @click="cancelForm">取消</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-drawer>
    </el-card>
</template>

<script>
import {
  Breakdown, DeleteBreakdown,
  ListBreakdown,
   SubmitForm,
} from "@/api/device/breakdown"
import {ListCompanyName,
  ListRouteName,
  ListRouteNameForCompany, SelfNum,
} from "@/api/device/dict/data"
import {getToken} from "@/utils/auth"
import ImageUpload from "@/components/ImageUpload/index"
export default {
  components:{
    ImageUpload
  },
  created() {
    // this.current = this.$store.state.pageState.articleList
    this.listBreakdown()
    this.listCompany()
    this.listRouteName()
  },
  data: function () {
    return {
      breakdowns:[],
      headers: { Authorization: "Bearer " + getToken() },
      companies:[],
      companyName:null,
      routeNames:[],
      routeName:null,
      selfNums:null,
      dialog:false,
      current: 1,
      size: 10,
      count: 0,
      status: null,
      breakdownStatus: 'all',
      loading: true,
      keywords: null,
      flushes:1,
      loadingForFrom:false,
      dialogForFrom:false,
      form:{},
      imageList:[],
      breakdownIds: [],
      isExport: false,
      type:[
        {
          value: 0,
          name:"主机故障"
        },
        {
          value: 1,
          name: "报站故障"
        },
        {
          value: 2,
          name: "摄像头故障"
        }
      ],
      formRules:{
        routeName: [
          { required: true, message: '请选择线路名', trigger: 'blur' }
        ],
        selfNum: [
          { required: true, message: '请选择自编号', trigger: 'blur' }
        ],
      },
      timer: null,
      formChange:0,
      remove: false,
    }
  },
  methods: {
    // 勾选表格记录事件new
    selectionChange(breakdowns) {
      this.breakdownIds = []
      breakdowns.forEach((item) => {
        this.breakdownIds.push(item.id)
      })
      console.log(this.breakdownIds.length)
    },
    // 条件查询new
    searchBreakdown() {
      this.current = 1
      this.listBreakdown()
    },

    // 导出记录按钮new
    exportBreakdowns() {
      this.download('device/faultUrl/export',{
        ids:this.breakdownIds
      },`${new Date().getTime()}.xlsx`)
      this.isExport=false
    },

    // 分页显示条数new
    sizeChange(size) {
      this.size = size
      this.listBreakdown()
    },
    //跳转当前页new
    currentChange(current) {
      this.current = current
      // this.$store.commit('updateArticleListPageState', current)
      this.listBreakdown()
    },
    //对应状态记录查找new
    changeStatus(status) {
      switch (status) {
        case 'all':
          this.status = null
          break
        case '未维护':
          this.status = 0
          break
        case '已维护':
          this.status = 1
          break
      }
      this.current = 1
      this.breakdownStatus = status
    },
    // 查询故障列表new
    listBreakdown(){
      this.loading=true
      let query={
        pageNum:this.current,
        pageSize:this.size,
        status:this.status,
        // companyName:this.companyName,
        routeName:this.routeName,
        searchValue:this.keywords
      }
      ListBreakdown(query).then(response => {
        this.breakdowns=response.rows
        this.count = response.total
        this.loading=false
      }).catch(error => {
        if(this.flushes<=1){
          this.$message('正在重试。。。');
          setTimeout(function (){
            this.listBreakdown()},2000)
          this.flushes++
        }
      })
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
    //预览图片new
    doPreviewImg(event,num){
      this.imageList=[]
      this.imageList.push(event)
      if(num<1){
        this.$refs.breakdownImg.showViewer = true
      }else {
        this.$refs.maintainImg.showViewer = true
      }
    },
    //查询自编号new
    selfNum(query){
      if(query!=null){
        let routeName={
          routeName:query
        }
        SelfNum(routeName).then(response => {
          this.selfNums=response.data
        })
      }
    },
    //故障图片上传回调new
    breakImage(url){
      this.form.url=url
    },
    //维护图片上传回调new
    mainImage(url){
      this.form.mainUrl=url
    },
    //编辑故障new
    editBreakdown(id){
      Breakdown(id).then(response =>{
        this.form=response.data
      })
      // this.formContextCopy=this.form
      this.dialogForFrom=true
    },
    //取消（关闭抽屉）new
    cancelForm(){
      this.dialogForFrom=false
      this.loadingForFrom = false;
      clearTimeout(this.timer);
    },
    //关闭抽屉前回调new
    handleClose(){
      if (this.loadingForFrom||this.formChange<=1) {
        this.dialogForFrom=false
        return;
      }
      this.$confirm('确定要保存吗？')
        .then(_ => {
          this.loadingForFrom = true;
          this.timer = setTimeout(() => {
            this.onSubmit()
            // 动画关闭需要一定的时间
            setTimeout(() => {
              this.loadingForFrom = false;
            }, 400);
          }, 2000);
        })
    },
    //关闭抽屉后回调new
    closedForm(){
      this.form={}
      this.$refs.form.resetFields()
      this.formChange=0
    },
    //表单提交new
    onSubmit(){
      this.$refs.form.validate((valid) => {
        if (valid) {
          console.log(this.form)
          SubmitForm(this.form).then(response => {
            console.log(response.data)
            this.$message({
              message: '保存成功',
              type: 'success'
            });
            this.dialogForFrom=false
            this.listBreakdown()
          }).catch(error => {
            this.$message.error('保存失败');
            this.listBreakdown()
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    //删除故障new
    deleteBreakdown(id){
      if(id!=null){
        DeleteBreakdown(id).then(response => {
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.listBreakdown()
        }).catch(error => {
          this.$message.error('删除失败');
          this.listBreakdown()
        })
      }else {
        DeleteBreakdown(this.breakdownIds).then(response => {
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.remove=false
          this.listBreakdown()
        }).catch(error => {
          this.remove=false
          this.$message.error('删除失败');
          this.listBreakdown()
        })
      }
    }
  },


  // 当查找的内容发生变化时，回到第一页
  watch: {
    //监听维护状态new
    status() {
      this.current = 1
      this.listBreakdown()
    },
    form:{
      handler(n,o){
        this.formChange++
      },
      deep:true
    },
    'form.routeName'(){
      this.selfNum(this.form.routeName)
    }
  },
  computed: {
    //故障类型标签样式和标签名new
    breakdownType() {
      return function (type) {
        var tagType = ''
        var name = ''
        switch (type) {
          case 0:
            tagType = 'danger'
            name = '主机故障'
            break
          case 1:
            tagType = 'warning'
            name = '报站故障'
            break
          case 2:
            tagType = 'warning'
            name = '摄像头故障'
            break
        }
        return {
          tagType: tagType,
          name: name
        }
      }
    },
    //监听选中的状态为当前状态时返回选中状态类名，为其他状态时返回其他状态类名new
    isActive() {
      return function (status) {
        return this.breakdownStatus === status ? 'active-status' : 'status'
      }
    },
  }
}
</script>

<style scoped>
.main-card {
  min-height: calc(100vh - 126px);
  margin-top: 1rem;
  margin-left: 1rem;
}
.operation-container {
  margin-top: 1.5rem;
  display: flex;
  margin-bottom: 1.5rem;
}
.article-status-menu {
  font-size: 14px;
  margin-top: 40px;
  color: #999;
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

