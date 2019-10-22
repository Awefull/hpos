<template>
  <div class="myApp-container">
    <div class="filter-container">
      <el-form>
        <el-form-item>
          <el-button type="success" icon="plus">筛选
          </el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit
              highlight-current-row>
      <el-table-column align="center" label="序号" width="80">
        <template slot-scope="scope">
          <span v-text="getIndex(scope.$index)"> </span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="username" label="账号">
      </el-table-column>
      <el-table-column align="center" prop="email" label="邮箱" width="420">
      </el-table-column>
      <el-table-column align="center" prop="address" label="所在城市" width="220">
      </el-table-column>
      <el-table-column align="center" prop="telephone" label="联系电话">
      </el-table-column>
      <el-table-column align="center" prop="unit_name" label="单位名称">
      </el-table-column>
      <el-table-column align="center" prop="is_examine" label="审核状态">
        <template slot-scope="scope">
          <el-button type="primary" round @click="examineOk = true" v-if="scope.row.is_examined==0">未审核</el-button>
          <el-button type="primary" round v-if="scope.row.is_examined==1" disabled="true">已审核</el-button>
          <el-dialog title="提示"
            :visible.sync="examineOk"
            width="30%" 
            :before-close="handleClose">
            <span>是否通过审核</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="examineOk = false">取 消</el-button>
              <el-button type="primary" @click="changeExamine(scope.$index)">确 定</el-button>
            </span>
          </el-dialog>
        </template>
          
      </el-table-column>
    </el-table>
    <el-pagination
      size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="user.pageNum"
      :page-size="user.pageRow"
      :total="totalCount"
      :page-sizes="[10, 20, 50, 100]"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        list: [],//表格的数据
        listLoading: false,//数据加载等待动画
        dialogStatus: 'create',
        totalCount: 0, //分页组件--数据总条数
        examineOk:false,
        index:'',
        user:{
          username:"",
          email:"",
          address:"",
          telephone:"",
          unit_name:"",
          is_examined:"",
          pageNum: 1,//页码
          pageRow: 50,//每页条数
        },
        userInfo:{
          id:"",
          username:"",
          email:"",
          address:"",
          telephone:"",
          unit_name:"",
          is_examined:"",
        },
      }
    },
    created() {
      this.getList();
    },
    methods: {
      getList() {
        //查询列表
        this.listLoading = true;
        this.api({
          url: "/Examine/getCompanyNotExamineAccountList",
          method: "get"
        }).then(data => {
          this.listLoading = false;
          this.list = data.list;
          this.totalCount = data.totalCount;
        })
      },
      getIndex($index) {
        //表格序号
        return $index + 1
      },
      changeExamine($index){
        this.userInfo = this.list[$index];
        this.api({
        url: "/Examine/updateExamineAccount",
          method: "post",
          data: this.userInfo
        }).then(() => {
          this.examineOk = false;
          this.userInfo.is_examined = 1;
        })
      }
    }
  }
</script>
<style scoped>
  .requiredPerm {
    color: #ff0e13;
  }
</style>
