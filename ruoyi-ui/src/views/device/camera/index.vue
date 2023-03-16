<template>
  <el-card class="main-card">
    <div class="title">{{ this.$route.name }}</div>
    <!--      状态选择栏-->
    <div class="article-status-menu">
      <el-button
        type="success"
        size="small"
        icon="el-icon-download"
        :disabled="true"
        @click="isExport = true">
        批量导出
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
    <el-table border :data="cameras" @selection-change="selectionChange" v-loading="loading" :header-cell-style="{background:'#FFFFFF'}">
      <el-table-column type="selection" width="55" />

      <el-table-column prop="reportTime" label="上报时间" width="130" align="center">
        <template slot-scope="scope">
          <i class="el-icon-time" style="margin-right: 5px" />
          {{ scope.row.reportTime}}
        </template>
      </el-table-column>

      <el-table-column prop="selfNum,routeName" label="线路/自编号" width="150" align="center">
        <template slot-scope="scope">
          {{scope.row.routeName}}/{{scope.row.selfNum}}
        </template>
      </el-table-column>

      <el-table-column prop="" label="车牌" align="center">
        <template >

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
  </el-card>
</template>

<script>

export default {
  components:{

  },
  created() {

  },
  data: function () {
    return {
      cameras:{},
      current:null,
      size:null,
      count:null,
    }
  },
  methods: {

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
  margin-top: 1.5rem;
  display: flex;
  margin-bottom: 1.5rem;
}
.article-status-menu {
  font-size: 14px;
  margin-top: 40px;
  color: #999;
  display: flex;
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

