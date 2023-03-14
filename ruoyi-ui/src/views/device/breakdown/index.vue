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
          v-if="isDelete == 0"
          type="danger"
          size="small"
          icon="el-icon-delete"
          :disabled="articleIds.length == 0"
          @click="updateIsDelete = true">
          批量删除
        </el-button>
        <el-button
          v-else
          type="danger"
          size="small"
          icon="el-icon-delete"
          :disabled="articleIds.length == 0"
          @click="remove = true">
          批量删除
        </el-button>
        <el-button
          type="success"
          size="small"
          icon="el-icon-download"
          :disabled="articleIds.length == 0"
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

<!--        <el-upload-->
<!--          action="/api/admin/articles/import"-->
<!--          multiple-->
<!--          :limit="9"-->
<!--          :show-file-list="false"-->
<!--          :headers="uploadHeaders"-->
<!--          :on-success="uploadArticle">-->
<!--          <el-button type="primary" size="small" icon="el-icon-upload"> 批量导入 </el-button>-->
<!--        </el-upload>-->

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
      <el-table border :data="breakdowns" @selection-change="selectionChange" v-loading="loading" header-cell-style="background:#FFFFFF">
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
<!--            <i v-if="scope.row.status == 1" class="iconfont el-icon-mygongkai article-status-icon" />-->
<!--            <i v-if="scope.row.status == 2" class="iconfont el-icon-mymima article-status-icon" />-->
<!--            <i v-if="scope.row.status == 3" class="iconfont el-icon-mycaogaoxiang article-status-icon" />-->
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
<!--            <i v-if="scope.row.status == 1" class="iconfont el-icon-mygongkai article-status-icon" />-->
<!--            <i v-if="scope.row.status == 2" class="iconfont el-icon-mymima article-status-icon" />-->
<!--            <i v-if="scope.row.status == 3" class="iconfont el-icon-mycaogaoxiang article-status-icon" />-->
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
              @confirm="updateArticleDelete(scope.row.id)"
              >
              <el-button size="mini" type="danger" slot="reference"> 删除 </el-button>
            </el-popconfirm>
<!--            回收状态功能按钮-->
<!--            <el-popconfirm-->
<!--              title="确定恢复吗？"-->
<!--              v-if="scope.row.isDelete == 1"-->
<!--              @confirm="updateArticleDelete(scope.row.id)">-->
<!--              <el-button size="mini" type="success" slot="reference"> 恢复 </el-button>-->
<!--            </el-popconfirm>-->
<!--            <el-popconfirm-->
<!--              style="margin-left: 10px"-->
<!--              v-if="scope.row.isDelete == 1"-->
<!--              title="确定彻底删除吗？"-->
<!--              @confirm="deleteArticles(scope.row.id)">-->
<!--              <el-button size="mini" type="danger" slot="reference"> 删除 </el-button>-->
<!--            </el-popconfirm>-->
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
        :page-sizes="[5, 10, 20]"
        layout="total, sizes, prev, pager, next, jumper" />

<!--      确认弹窗-->
      <el-dialog :visible.sync="updateIsDelete" width="30%">
        <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" />提示</div>
        <div style="font-size: 1rem">是否删除选中项？</div>
        <div slot="footer">
          <el-button @click="updateIsDelete = false">取 消</el-button>
          <el-button type="primary" @click="updateArticleDelete(null)"> 确 定 </el-button>
        </div>
      </el-dialog>
      <el-dialog :visible.sync="remove" width="30%">
        <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" />提示</div>
        <div style="font-size: 1rem">是否彻底删除选中项？</div>
        <div slot="footer">
          <el-button @click="remove = false">取 消</el-button>
          <el-button type="primary" @click="deleteArticles(null)"> 确 定 </el-button>
        </div>
      </el-dialog>
      <el-dialog :visible.sync="isExport" width="30%">
        <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" />提示</div>
        <div style="font-size: 1rem">是否导出选中文章？</div>
        <div slot="footer">
          <el-button @click="isExport = false">取 消</el-button>
          <el-button type="primary" @click="exportArticles(null)"> 确 定 </el-button>
        </div>
      </el-dialog>
<!--      提交表单-->
      <el-drawer
        title="新增故障"
        :before-close="handleClose"
        :visible.sync="dialogForFrom"
        @closed="closedForm"
        destroy-on-close="true"
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
            <el-form-item label="线路名" prop="route">
              <el-col :span="8" prop="route">
                <el-select placeholder="选择线路名" v-model="form.routeName" filterable style="width: 100%;">
                  <el-option v-for="item in routeNames" :value="item.routeName"></el-option>
                </el-select>
              </el-col>
              <el-col class="line" :span="3" style="margin-left: 0.5rem">-自编号</el-col>
              <el-col :span="8">
                <el-select placeholder="选择自编号" v-model="form.selfNum" filterable style="width: 100%;">
                  <el-option v-for="item in selfNums" :value="item.selfNum"></el-option>
                </el-select>
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
              <el-tooltip :content="form.status?'已维护':'未维护'" placement="right" effect="light">
                <el-switch v-model="form.status>0"></el-switch>
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
<!--          <div class="drawer__footer">-->
<!--            <el-button @click="cancelForm">取 消</el-button>-->
<!--            <el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>-->
<!--          </div>-->
        </div>
      </el-drawer>
    </el-card>
</template>

<script>
import {
  Breakdown,
  ListBreakdown,
  ListCompanyName,
  ListRouteName,
  ListRouteNameForCompany,
} from "@/api/device/breakdown"
import {getToken} from "@/utils/auth"
import ImageUpload from "@/components/ImageUpload/index"
// import {isObject} from "echarts/types/dist/echarts";
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
      form:{
        consuming: null,
        createBy: null,
        createTime: null,
        description: null,
        driverId: 0,
        id: 0,
        mainUrl: null,
        maintainDescription: null,
        maintainTime: null,
        maintainer: null,
        params: {},
        phone: null,
        remark: null,
        reportTime: null,
        routeName: null,
        selfNum: null,
        status: 0,
        type: null,
        updateBy: null,
        updateTime: null,
        url: null,
        vehicleId: 0
      },
      imageList:[],
      articleIds: [],
      isDelete: 0,
      isExport: false,
      formLabelWidth:"5rem",
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
        route: [
          { required: true, message: '请选择线路名和自编号', trigger: 'blur' }
        ],
      },
      timer: null,
      formChange:0,
      // formContextCopy:null,


      // updateIsDelete: false,
      // remove: false,
      // articles: [],
      // categories: [],
      // tags: [],
      // type: null,
      // categoryId: null,
      // tagId: null,
    }
  },
  methods: {
    // 勾选表格记录事件
    selectionChange(articles) {
      this.articleIds = []
      articles.forEach((item) => {
        this.articleIds.push(item.id)
      })
    },
    // 条件查询new
    searchBreakdown() {
      this.current = 1
      this.listBreakdown()
    },

    // 删除/恢复按钮
    updateArticleDelete(id) {
      let param = {}
      if (id != null) {
        param.ids = [id]
      } else {
        param.ids = this.articleIds
      }
      param.isDelete = this.isDelete == 0 ? 1 : 0
      this.axios.put('/api/admin/articles', param).then(({ data }) => {
        if (data.flag) {
          this.$notify.success({
            title: '成功',
            message: data.message
          })
          this.listArticles()
        } else {
          this.$notify.error({
            title: '失败',
            message: data.message
          })
        }
        this.updateIsDelete = false
      })
    },
    // 彻底删除按钮
    deleteArticles(id) {
      let param = {}
      if (id == null) {
        param = { data: this.articleIds }
      } else {
        param = { data: [id] }
      }
      this.axios.delete('/api/admin/articles/delete', param).then(({ data }) => {
        if (data.flag) {
          this.$notify.success({
            title: '成功',
            message: data.message
          })
          this.listArticles()
        } else {
          this.$notify.error({
            title: '失败',
            message: data.message
          })
        }
        this.remove = false
      })
    },
    // 导出记录按钮
    exportArticles(id) {
      var param = {}
      if (id == null) {
        param = this.articleIds
      } else {
        param = [id]
      }
      this.axios.post('/api/admin/articles/export', param).then(({ data }) => {
        if (data.flag) {
          this.$notify.success({
            title: '成功',
            message: data.message
          })
          data.data.forEach((item) => {
            this.downloadFile(item)
          })
          this.listArticles()
        } else {
          this.$notify.error({
            title: '失败',
            message: data.message
          })
        }
        this.isExport = false
      })
    },
    //下载导出记录
    downloadFile(url) {
      const iframe = document.createElement('iframe')
      iframe.style.display = 'none'
      iframe.style.height = 0
      iframe.src = url
      document.body.appendChild(iframe)
      setTimeout(() => {
        iframe.remove()
      }, 5 * 60 * 1000)
    },
    // 导入按钮
    uploadArticle(data) {
      if (data.flag) {
        this.$notify.success({
          title: '成功',
          message: '导入成功'
        })
        this.listArticles()
      } else {
        this.$notify.error({
          title: '失败',
          message: data.message
        })
      }
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
          setTimeout(function (){this.listBreakdown()},2000)
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
    //取消（关闭抽屉）
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
            done();
            // 动画关闭需要一定的时间
            setTimeout(() => {
              this.loadingForFrom = false;
            }, 400);
          }, 2000);
        })
        .catch(_ => {});
    },
    //关闭抽屉后回调new
    closedForm(){
      this.form=[]
      this.$refs.form.resetFields()
      this.formChange=0
    },
    //表单提交
    onSubmit(){
      this.$refs.form.validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    // isEqual(obj1, obj2) {
    //   // 1.判断是不是引用类型，不是引用
    //   if (!typeof (obj1)=="object" || !typeof (obj2)=="object") {
    //     return obj1 === obj2;
    //   }
    //   // 2.比较是否为同一个内存地址
    //   if (obj1 === obj2) return true;
    //   // 3.比较 key 的数量
    //   const obj1KeysLength = Object.keys(obj1).length;
    //   const obj2KeysLength = Object.keys(obj2).length;
    //   if (obj1KeysLength !== obj2KeysLength) return false;
    //   // 4.比较 value 的值
    //   for (let key in obj1) {
    //     const result = this.isEqual(obj1[key], obj2[key]);
    //     if(!result) return false;
    //   }
    //   return true;
    // }
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
    // formContextChange:{
    //   handler(n,o){
    //     if(n && this.isEqual(n,o)){
    //       this.formChange=0
    //     }
    //   },
    //   deep:true
    // }
    // routeName(){
    //   if(this.routeName===""){
    //     this.companyName=""
    //   }
    //   else {
    //     for(let item of this.routeNames){
    //       if(this.routeName===item.routeName)
    //         this.companyName=item.groupName
    //     }
    //   }
    // }
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
        return this.breakdownStatus == status ? 'active-status' : 'status'
      }
    },
    // formContextChange(){
    //   console.log("-----"+JSON.parse(JSON.stringify(this.formContextCopy)))
    //   return JSON.parse(JSON.stringify(this.formContextCopy))
    // }
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
.drawer__content{

}
.drawer__footer{
  float: right;
  margin-right: 6rem;
}
</style>

