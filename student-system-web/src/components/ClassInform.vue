<template>
  <div style="margin-left: 10%;margin-top: 5%">
    <el-table :data="tableDataList" :default-sort = "{prop: 'date', order: 'descending'}" max-height="400px"  stripe style="width: 60%;">
      <el-table-column sortable prop="notificationDate" :formatter="dateFormat" label="日期" style="text-align: center"></el-table-column>
      <el-table-column prop="notificationTitle" label="标题"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block" style="margin-right: 10%; margin-top: 1%">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        :page-sizes="[5, 10, 20, 30]"
        :page-size="10"
        layout="sizes, prev, pager, next"
        :total="50">
      </el-pagination>
    </div>

    <el-dialog title="班级通知" :visible.sync="dialogVisible" width="30%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
    import * as fecha from 'element-ui/lib/utils/date';

    export default {
      name: "ClassInform",
      data(){
        return{
          currentPage:0,
          tableDataList: [],
          dialogVisible:false,
        }
      },

      created() {
        this.initTable();
      },

      methods:{
        initTable(){
          let that=this;
          this.$axios.post("http://localhost:8889/system/student/classInform",{
            account:this.$cookie.get('account'),
            notificationType:'2'
          }).then(function (res) {
            console.log(res);
            that.tableDataList=res.data.data;
          }).catch(function (err) {
            console.log(err);
          })
        },

        handleClick(item){
          this.dialogVisible=true;
        },

        handleSizeChange(val) {
          console.log(`每页 ${val} 条`);
        },

        handleCurrentChange(val) {
          console.log(`当前页: ${val}`);
        },

        dateFormat(row, column, cellValue) {
          return cellValue ? fecha.format(new Date(cellValue), 'yyyy-MM-dd HH:mm:ss') : '';
        },
      }
    }
</script>

<style scoped>

</style>
