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
        <el-table-column align="center" prop="deposit" label="定金">
        </el-table-column>
        <el-table-column align="center" prop="depositIsPayed" label="定金支付情况">
            <template slot-scope="scope">
                <el-button type="primary" @click="deposit(scope.$index)" v-if="scope.row.depositIsPayed==0">
                未支付
                </el-button>
                <el-button type="primary" v-if="scope.row.depositIsPayed==1" disabled="true">
                已支付
                </el-button>
                <el-dialog title="提示"
                    :visible.sync="costDepositOk"
                    width="30%" 
                    :before-close="handleClose1">
                    <span>是否支付定金</span>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="costDepositOk = false">取 消</el-button>
                        <el-button type="primary" @click="costDeposit()">确 定</el-button>
                    </span>
                </el-dialog>
            </template>    
        </el-table-column>
        <el-table-column align="center" prop="finalPayment" label="尾款">
        </el-table-column>
        <el-table-column align="center" prop="finalPaymentIsPayed" label="尾款支付情况">
            <template slot-scope="scope">
                <el-button type="primary" @click="finalPayment(scope.$index)" v-if="scope.row.finalPaymentIsPayed==0">
                未支付
                </el-button>
                <el-button type="primary" v-if="scope.row.finalPaymentIsPayed==1" disabled="true">
                已支付
                </el-button>
                <el-dialog title="提示"
                    :visible.sync="costFinal_paymentOk"
                    width="30%" 
                    :before-close="handleClose2">
                    <span>是否支付尾款</span>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="costFinal_paymentOk = false">取 消</el-button>
                        <el-button type="primary" @click="costFinal_payment()">确 定</el-button>
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
        costDepositOk:false,
        costFinal_paymentOk:false,
        index:'',
        user:{
            projectName:"",
            companyName:"",
            studioName:"",
            deposit:"",
            depositIsPayed:"",
            finalPayment:"",
            finalPaymentIsPayed:"",
            pageNum: 1,//页码
            pageRow: 50,//每页条数
        },
        userInfo:{
            id:"",
            projectName:"",
            companyName:"",
            studioName:"",
            deposit:"",
            depositIsPayed:"",
            finalPayment:"",
            finalPaymentIsPayed:"",
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
            url: "/Cost/getCostManagement",
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
        deposit(index) {
            this.costDepositOk = true;
            this.index = index;
        },
        finalPayment(index) {
            this.costFinal_paymentOk = true;
            this.index = index;
        },
        costDeposit(){
            this.userInfo = this.list[this.index];
            this.api({
        url: "/Cost/updateCostDeposit",
            method: "post",
            data: this.userInfo
        }).then(() => {
            this.costDepositOk = false;
            this.userInfo.depositIsPayed = 1;
        })
        },
        costFinal_payment(){
            this.userInfo = this.list[this.index];
            this.api({
        url: "/Cost/updateCostFinal_payment",
            method: "post",
            data: this.userInfo
        }).then(() => {
            this.costFinal_paymentOk = false;
            this.userInfo.finalPaymentIsPayed = 1;
        })
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
        handleClose1(done) {
            this.costDepositOk = false;
        },
        handleClose2(done) {
            this.costFinal_paymentOk = false;
        }
    }
}
</script>
<style scoped>
    .requiredPerm {
        color: #ff0e13;
    }
</style>