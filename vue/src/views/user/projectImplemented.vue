<template>
    <div class="myApp-container">
        <div class="search_container">
            <el-form 
                :inline="true" 
                :model='searchData' 
                :rules="searchFormRules"
                ref="searchData"  
                class="demo-form-inline search-form">
                <el-form-item prop='projectName' label="筛选信息:">
                    <el-input type="text" v-model="searchData.key" placeholder="请输入筛选条件"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click='screeoutName(searchData.key)'>筛选</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="danger" @click='getList()'>重置</el-button>
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
        <el-table-column align="center" prop="projectName" label="项目名称">
        </el-table-column>
        <el-table-column align="center" prop="progressLog" label="项目进度">
        </el-table-column>
        <el-table-column align="center" prop="date" label="日期">
        </el-table-column>
        <el-table-column align="center" prop="companyName" label="公司名称">
        </el-table-column>
        <el-table-column align="center" prop="studioName" label="工作室名称">
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
        resultsList:[],
        totalCount: 0, //分页组件--数据总条数
        index:'',
        searchData:{
            key:""
        },
        searchFormRules: {
            key: [{
                required: false,
                message : '输入信息不能为空！',
                trigger : 'blur'
            }]
        },
        user:{
            projectName:"",
            progressLog:"",
            date:"",
            companyName:"",
            studioName:"",
            pageNum: 1,//页码
            pageRow: 50,//每页条数
        },
        userInfo:{
            id:"",
            projectName:"",
            progressLog:"",
            date:"",
            companyName:"",
            studioName:"",
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
            url: "/Implement/getProgressLog",
            method: "get",
            params:this.user,
        }).then(data => {
            this.listLoading = false;
            this.list = data.list;
            this.totalCount = data.totalCount;
            this.resultsList = data.list;
            for (var i = 0; i < this.resultsList.length; i++) {
                let update = this.transformDate(this.resultsList[i].date);
                this.resultsList[i].date = update;
            }
        })
        },
        handleSizeChange(val) {
        //改变每页数量
        this.user.pageRow = val;
        this.handleFilter();
        },
        handleCurrentChange(val) {
        //改变页码
        this.user.pageNum = val;
        this.getList();
        },
        handleFilter() {
        //查询事件
        this.user.pageNum = 1;
        this.getList();
        },
        screeoutName:function(projectName){
            //查询列表
            this.user.key = projectName;
            // this.listLoading = true;
            this.api({
                url: "/Implement/FoundList",
                method: "post",
                data:this.user,
            }).then(data => {
                // this.listLoading = false;
                this.list = data.list;
                this.totalCount = data.totalCount;
                this.resultsList = data.list;
                for (var i = 0; i < this.resultsList.length; i++) {
                    let update = this.transformDate(this.resultsList[i].date);
                    this.resultsList[i].date = update;
                }
            })
        },
        getIndex($index) {
        //表格序号
        return (this.user.pageNum - 1) * this.user.pageRow + $index + 1
        },
        transformDate(update) {
            update = update.replace(/T/," ");
            update = update.replace(/\+/,"0");
            update = update.replace(/(0+)$/g,"");
            update = update.replace(/\./,"");
            return update;
        }
    }
}
</script>
<style scoped>
    .requiredPerm {
        color: #ff0e13;
    }
    .search_container{
        height: 36px;
        line-height: 36px;
        margin-bottom:10px;
    }
</style>