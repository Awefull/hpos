<template>
    <div class="myApp-container">
        <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit
            highlight-current-row>
        <el-table-column align="center" label="序号" width="80">
            <template slot-scope="scope">
                <span v-text="getIndex(scope.$index)"> </span>
            </template>
        </el-table-column>
        <el-table-column align="center" prop="projectName" label="项目标题">
        </el-table-column>
        <el-table-column align="center" prop="companyName" label="企业名称">
        </el-table-column>
        <el-table-column align="center" prop="studioName" label="工作室名称">
        </el-table-column>
        <el-table-column align="center" prop="applyNum" label="招标人数">
        </el-table-column>
        <el-table-column align="center" prop="tenderStatus" label="招募进度"
        :filters="[{ text: '招标完成', value: '1' }, { text: '招标中', value: '0' }]"
        :filter-method="filterBtn"
        filter-placement="bottom-end">
            <template slot-scope="scope">
                <el-button type="primary" name="btn1" v-if="scope.row.tenderStatus==0">
                招募中
                </el-button>
                <el-button type="primary" name="btn1" v-if="scope.row.tenderStatus==1">
                招募完成
                </el-button> 
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
            index:'',
            user:{
            projectName:"",
            companyName:"",
            sutdioName:"",
            applyNum:"",
            tenderStatus:"",
            pageNum: 1,//页码
            pageRow: 50,//每页条数
            }
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
            url: "/Admin/getProjectMessagelist",
            method: "get"
            }).then(data => {
            this.listLoading = false;
            this.list = data.list;
            this.totalCount = data.totalCount;
            })
        },
        getIndex($index) {
        //表格序号
        return (this.user.pageNum - 1) * this.user.pageRow + $index + 1
        },
        handleSizeChange(val) {
        //改变每页数量
        this.user.pageRow = val
        this.handleFilter();
        },
        handleCurrentChange(val) {
        //改变页码
        this.user.pageNum = val
        this.getList();
        },
        filterBtn(value, row) {
        return row.tenderStatus == parseInt(value);
        }
        }
    }
</script>
<style scoped>
    .requiredPerm {
        color: #ff0e13;
    }
</style>
