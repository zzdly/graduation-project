<template>
  <div style="margin-left: 10%;margin-top: 5%">
    <el-table :data="tableDataList" :default-sort = "{prop: 'date', order: 'descending'}" max-height="400px"  border style="width: 60%;">
      <el-table-column sortable prop="date" label="学年" style="text-align: center"></el-table-column>
      <el-table-column prop="course" label="绩点"></el-table-column>
      <el-table-column prop="score" label="排名"></el-table-column>
    </el-table>
  </div>
</template>

<script>
    export default {
      name: "gradePointAverageQuery",
      data(){
          return{
            tableDataList: [],
          }
      }
    }
</script>

<style scoped>

</style>
