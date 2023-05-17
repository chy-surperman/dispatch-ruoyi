<template>
  <el-card class="main-card">
    <div class="title">{{ this.$route.name }}</div>
    <!--      状态选择栏-->
    <div class="operation-container">
      <el-upload
        class="upload-demo"
        ref="upload"
        :on-success="inductsOver"
        :action="url"
        :auto-upload="true"
        :show-file-list="false"
        :headers="headers"
        style="margin-right: 0.5rem">
        <el-button icon="el-icon-download" slot="trigger" size="small" type="primary">导入文档</el-button>
      </el-upload>

      <el-button
        type="danger"
        size="small"
        icon="el-icon-download"
        :disabled="!resultGps.length"
        @click="clsDocument">
        清除文档
      </el-button>
      <el-button
        type="success"
        size="small"
        icon="el-icon-download"
        :disabled="!resultGps.length"
        @click="isExport = true">
        导出文档
      </el-button>
    </div>
    <!--      表格主体-->
    <el-table border :data="resultGps" v-loading="loading"  :header-cell-style="{background:'#FFFFFF'}" >
      <!--      <el-table-column type="selection" width="55" />-->
      <el-table-column label="站点" align="center" >

        <el-table-column prop="sequence" label="站点顺序" width="150" align="center">
          <template slot-scope="scope">
            {{ scope.row.sequence}}
          </template>
        </el-table-column>

        <el-table-column prop="routeName" label="线路名" align="center">
          <template slot-scope="scope">
            {{scope.row.routeName}}
          </template>
        </el-table-column>

        <el-table-column prop="starttag" label="方向(上行/下行)" align="center">
          <template slot-scope="scope">
            {{scope.row.starttag}}
          </template>
        </el-table-column>

        <el-table-column prop="siteName" label="站点名称" align="center">
          <template slot-scope="scope">
            {{scope.row.siteName}}
          </template>
        </el-table-column>

      </el-table-column>


      <el-table-column label="GPS84坐标" align="center">
        <el-table-column prop="latitude" label="纬度" align="center">
          <template slot-scope="scope">
            <span style="font-family: maoken;color: #1ab394;">{{scope.row.latitude}}</span>
          </template>
        </el-table-column>

        <el-table-column prop="longitude" label="经度" align="center">
          <template slot-scope="scope">
            <span style="font-family: maoken;color: #1ab394;">{{scope.row.longitude}}</span>
          </template>
        </el-table-column>

      </el-table-column>

    </el-table>

<!--    弹窗-->
    <el-dialog :visible.sync="isExport" width="30%">
      <div class="dialog-title-container" slot="title"><i class="el-icon-warning" style="color: #ff9900" /><span style="font-family: maoken;color: brown">提示</span></div>
      <div style="font-size: 1rem;font-family: maoken">是否导出？</div>
      <div slot="footer">
        <el-button @click="isExport = false">取 消</el-button>
        <el-button type="primary" @click="exportDocument()"> 确 定 </el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
import {getToken} from "@/utils/auth";
export default {
  components:{

  },
  created() {
  },
  data: function () {
    return {
      resultGps:[],
      loading:false,
      isExport:false,
      url: process.env.VUE_APP_BASE_API + "/device/gpsConvert/importData",
      headers: {
        Authorization: "Bearer " + getToken(),
      },
    }
  },
  methods: {
    inductsOver(response){
      this.resultGps=response.data
    },
    clsDocument(){
      this.resultGps=[]
    },

    // 导出文档按钮new
    exportDocument() {
      let routeName=this.resultGps[0].routeName
      this.download('/device/gpsConvert/exportGpsConvertSite',{
        routeName:routeName
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


