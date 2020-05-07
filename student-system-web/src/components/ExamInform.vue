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
        :page-sizes="[5, 10, 20, 30]"
        :current-page.sync="currentPage"
        :page-size="limit"
        layout="sizes, prev, pager, next"
        :total="listTotal">
      </el-pagination>
    </div>

    <el-dialog title="考试通知" :visible.sync="dialogVisible" width="30%">
      <quill-editor
        disabled
        v-model="content"
        ref="myQuillEditor"
        :options="editorOption"
        @blur="onEditorBlur($event)"
        @focus="onEditorFocus($event)"
        @change="onEditorChange($event)">
      </quill-editor>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
    import * as fecha from "element-ui/lib/utils/date";

    export default {
      name: "ExamInform",
      data(){
        return{
          listTotal:0,
          currentPage:1,
          limit:5,
          tableDataList: [],
          dialogVisible:false,
          content:'',
          editorOption:{
            theme:'bubble',
          }
        }
      },
      created() {
        this.initTable();
      },
      methods:{
        initTable(){
          let that=this;
          this.$axios.post("http://localhost:8889/system/student/examInform",{
            account:this.$cookie.get('account'),
            notificationType:'3'
          }).then(function (res) {
            console.log(res);
            that.tableDataList=res.data.data;
            that.listTotal=res.data.data.length;
          }).catch(function (err) {
            console.log(err);
          })
        },

        handleClick(item){
          this.dialogVisible=true;
          this.content=item.notificationContent;
        },

        handleSizeChange(val) {
          //console.log(`每页 ${val} 条`);
          this.limit=val;
          this.initTable();
        },

        handleCurrentChange(val) {
          //console.log(`当前页: ${val}`);
          this.currentPage=val;
          this.initTable();
        },

        dateFormat(row, column, cellValue) {
          return cellValue ? fecha.format(new Date(cellValue), 'yyyy-MM-dd HH:mm:ss') : '';
        },

        onEditorBlur(){},//富文本失去焦点事件
        onEditorFocus(){},//富文本获得焦点事件
        onEditorChange(){}//富文本内容改变事件
      }
    }
</script>

<style scoped>

</style>
