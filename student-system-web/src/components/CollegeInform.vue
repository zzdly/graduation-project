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

    <el-dialog title="学院通知" :visible.sync="dialogVisible" width="30%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
    import * as fecha from "element-ui/lib/utils/date";

    export default {
      name: "CollegeInform",
      data(){
        return{
          tableDataList: [],
          dialogVisible:false //弹框状态
        }
      },
      created() {
        this.initTable();
      },
      methods:{
        initTable(){
          let that=this;
          this.$axios.post("http://localhost:8889/system/student/collegeInform",{
            account:this.$cookie.get('account'),
            notificationType:'1'
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

        dateFormat(row, column, cellValue) {
          return cellValue ? fecha.format(new Date(cellValue), 'yyyy-MM-dd HH:mm:ss') : '';
        },
      }
    }
</script>

<style scoped>

</style>
