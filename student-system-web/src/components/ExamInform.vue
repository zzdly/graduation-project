<template>
  <div style="margin-left: 10%;margin-top: 5%">
    <el-table :data="tableDataList" :default-sort = "{prop: 'date', order: 'descending'}" max-height="400px"  border style="width: 60%;">
      <el-table-column sortable prop="date" label="日期" style="text-align: center"></el-table-column>
      <el-table-column prop="course" label="标题"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">详情</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
    export default {
      name: "ExamInform",
      data(){
        return{
          tableDataList: [],
        }
      },
      created() {

      },
      methods:{
        handleClick(){

        }
      }
    }
</script>

<style scoped>

</style>
