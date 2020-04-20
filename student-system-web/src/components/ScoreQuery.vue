<template>
  <div style="margin-left: 10%;margin-top: 5%">
    <el-table :data="tableDataList" :default-sort = "{prop: 'date', order: 'descending'}" height="635px"  border style="width: 60%;">
      <el-table-column sortable prop="date" label="学年" style="text-align: center"></el-table-column>
      <el-table-column prop="course" label="课程"></el-table-column>
      <el-table-column prop="score" label="成绩"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 50px; margin-right: 20%">
      <el-form :inline="true" :model="searchParams" class="demo-form-inline">
        <el-form-item label="课程">
          <el-input v-model="searchParams.course" placeholder="请输入课程"></el-input>
        </el-form-item>
        <el-form-item label="学年">
          <el-input v-model="searchParams.date" placeholder='例:2016-2017-1'></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="scoreQuery">搜索</el-button>
        </el-form-item>
      </el-form>
    </div>

    <el-dialog title="详细信息" :visible.sync="dialogFormVisible" width="350px">
      <div>
        <el-form :model="scoreDetailsForm" inline style="text-align: right">
          <el-form-item label="平时占比" :label-width="100">
            <el-input v-model="scoreDetailsForm.peacetimeRatio" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="平时成绩" :label-width="100">
            <el-input v-model="scoreDetailsForm.peacetimeScore" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="考试占比" :label-width="100">
            <el-input v-model="scoreDetailsForm.examRatio" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="考试成绩" :label-width="100">
            <el-input v-model="scoreDetailsForm.examScore" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="最终成绩" :label-width="100">
            <el-input v-model="scoreDetailsForm.finalScore" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="绩点" :label-width="100">
            <el-input v-model="scoreDetailsForm.gradePointAverage" autocomplete="off" disabled></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
    export default {
      name: "ScoreQuery",
      data() {
        return {
          //表格数据
          tableDataList: [],
          //搜索数据
          searchParams:{
            course:'',//课程
            date:'',//学年
          },
          //返回列表数据的模拟
          List:[
            {
              date:'1',
              course:'1' ,
              score:'1'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            },
            {
              date:'2',
              course:'2' ,
              score:'2'
            }
          ],
          //对话框显示标志
          dialogFormVisible: false,
          //对话框数据
          scoreDetailsForm: {
            peacetimeRatio:'',//平时比例
            peacetimeScore:'',//平时成绩
            examRatio:'',//考试比例
            examScore:'',//考试成绩
            finalScore:'',//最终成绩
            gradePointAverage:''//绩点
          },
        }
      },
      created() {
        this.tableData();
        this.tableDataList=this.List;
      },
      methods:{
        /***
         * 初始化及渲染表格
         */
        tableData(){
          console.log("1123",this.searchParams.date,this.searchParams.course)
          this.$axios.post("http://localhost:8889/system/student/scoreQuery",{
            date:this.searchParams.date,
            course:this.searchParams.course,
          }).then(function (res) {
            console.log("成绩搜索返回成功数据：",res);
          }).catch(function (err) {
            console.log("成绩搜索失败返回数据",err);
          })
        },
        /**
         * 查询方法
         */
        scoreQuery(){
          this.tableData();
        },
        handleClick(row) {
          this.dialogFormVisible=true;
          console.log(row);
        }
      }
    }
</script>


<style scoped>

</style>
