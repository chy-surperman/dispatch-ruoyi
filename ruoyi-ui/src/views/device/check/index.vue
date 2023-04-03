<template>
  <el-card class="main-card">
    <div class="title">{{ this.$route.name }}</div>
    <!--      状态选择栏-->
    <div class="operation-container">
      <el-button
        type="success"
        size="small"
        icon="el-icon-download"
        :disabled="false"
        @click="isExport = true">
        导出文档
      </el-button>
      <!--        搜索栏-->
      <div style="margin-left: auto">
        <el-date-picker
          v-model="queryDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择日期">
        </el-date-picker>
        <el-button type="primary" size="small" icon="el-icon-search" style="margin-left: 1rem" @click="searchCheck">
          搜索
        </el-button>
      </div>
    </div>
    <!--      表格主体-->
    <el-table border :data="checks" v-loading="loading" @selection-change="selectionChange"  :header-cell-style="{background:'#FFFFFF'}">
<!--      <el-table-column type="selection" width="55" />-->
      <el-table-column type="index" width="55" align="center"/>

      <el-table-column prop="company" label="公司" width="200" align="center">
        <template slot-scope="scope">
          {{ scope.row.company}}
        </template>
      </el-table-column>

      <el-table-column prop="selfNum,routeName" label="线路/自编号" width="170" align="center">
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

      <el-table-column prop="iccid" label="摄像头编号" align="center">
        <template slot-scope="scope">
          <span style="font-family: maoken;color: #1ab394;"><i class="el-icon-video-camera" style="color: black;margin-right: 0.5rem;align-self: center;"/>{{scope.row.cameraId}}</span>
        </template>
      </el-table-column>

      <el-table-column prop="have" label="有录像次数" width="150" align="center">
        <template slot-scope="scope">
          <i class="el-icon-document-checked" style="color: #1ab394;margin-right: 0.5rem"/>{{scope.row.have}}
        </template>
      </el-table-column>

      <el-table-column prop="notHave" label="无录像次数" width="150" align="center">
        <template slot-scope="scope">
          <i class="el-icon-document-delete" style="color: #1ab394;margin-right: 0.5rem"/>{{scope.row.notHave}}
        </template>
      </el-table-column>

      <el-table-column prop="total" label="总计录像次数" width="150" align="center">
        <template slot-scope="scope">
          <i class="el-icon-document" style="color: #1ab394;margin-right: 0.5rem"/>{{scope.row.total}}
        </template>
      </el-table-column>

    </el-table>
    <!--      分页插件-->
<!--    <el-pagination-->
<!--      class="pagination-container"-->
<!--      background-->
<!--      @size-change="sizeChange"-->
<!--      @current-change="currentChange"-->
<!--      :current-page="current"-->
<!--      :page-size="size"-->
<!--      :total="count"-->
<!--      :page-sizes="[5, 10, 20,count]"-->
<!--      layout="total, sizes, prev, pager, next, jumper" />-->

    <el-dialog :visible.sync="isExport" width="30%">
      <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" /><span style="font-family: maoken;color: brown">提示</span></div>
      <div style="font-size: 1rem;font-family: maoken">是否导出？</div>
      <div slot="footer">
        <el-button @click="isExport = false">取 消</el-button>
        <el-button type="primary" @click="exportChecks()"> 确 定 </el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
import {CameraCheck} from "@/api/device/check";
export default {
  components:{

  },
  created() {
    this.cameraCheck()
  },
  data: function () {
    return {
      checks:[],
      current:1,
      size:null,
      count:null,
      keywords: null,
      flushes:1,
      loading:false,
      checkIds:[],
      queryDate:new Date(),
      isExport:false
    }
  },
  methods: {
    selectionChange(cameras){
      this.checkIds=[]
      for(let i of cameras){
        this.checkIds.push(i.id)
      }
    },
    //查询摄像头列表
    cameraCheck(){
      this.loading=true
      if (this.queryDate>10){
        this.queryDate=this.queryDate.getFullYear()+"-"+
          (this.queryDate.getMonth()<10 ? "0" : "")+(this.queryDate.getMonth()+1)+"-"+
          (this.queryDate.getDate()<10 ? "0":"")+(this.queryDate.getDate()-1)
      }
      let query = { workdate:this.queryDate }
      CameraCheck(query).then(response => {
        this.checks = response.data
        this.loading=false
      })
    },
    //条件查询
    searchCheck(){
      this.current=1
      this.cameraCheck()
    },
    //分页显示条数
    sizeChange(size){
      this.size=size
      this.cameraCheck()
    },
    //页码跳转
    currentChange(current){
      this.current=current
      this.cameraCheck()
    },
    // 导出记录按钮new
    exportChecks() {
      this.download('/device/vehicleId/exportCamera',{
        workdate: this.queryDate
      },`${new Date().getTime()}.xlsx`)
      this.isExport=false
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

