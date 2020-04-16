<template>
  <div>
    <el-table :data="tableDataList" :default-sort = "{prop: 'date', order: 'descending'}" height="450" border style="width: 60%;margin: 0 auto;">
      <el-table-column sortable prop="date" label="学年" width="180" style="text-align: center"></el-table-column>
      <el-table-column prop="course" label="课程" width="180"></el-table-column>
      <el-table-column prop="score" label="成绩"></el-table-column>
    </el-table>
    <div style="text-align: right;margin-top: 50px">
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
  </div>
</template>

<script>
    export default {
      name: "ScoreQuery",
      data() {
        return {
          tableDataList: [],

          searchParams:{
            course:'',
            date:'',
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
            }
          ]

        }
      },

      created() {
        this.tableDataList=this.List;
      },
      methods:{
        scoreQuery(){

        },

      }
    }
</script>
<style>

</style>

<style scoped>

</style>
