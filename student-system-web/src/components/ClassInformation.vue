<template>
  <div style="margin-left: 10%;margin-top: 5%">
    <table width="80%" height="500" cellpadding="0" cellspacing="0">
      <tr>
        <td width="10%" align="right">班级名称：</td>
        <td colspan="5">{{this.tableData.className}}</td>
      </tr>
      <tr>
        <td align="right">班级QQ群：</td>
        <td colspan="5">{{this.tableData.classQQ}}</td>
      </tr>
      <tr>
        <td align="right">班级宣传语：</td>
        <td colspan="5">{{this.tableData.classManifesto}}</td>
      </tr>
      <tr>
        <td align="right">所属学院：</td>
        <td colspan="5">{{this.tableData.department}}</td>
      </tr>

      <tr>
        <td align="right">班主任老师：</td>
        <td width="40%">{{this.tableData.teacherName}}</td>
        <td width="10%">电话：</td>
        <td width="40%">{{this.tableData.teacherPhone}}</td>
      </tr>

      <tr>
        <td rowspan="2" align="right">意见或建议：</td>
        <td colspan="3">
          <el-input type="textarea" :rows="8" placeholder="请输入内容" v-model="tableData.suggest"></el-input>
        </td>
      </tr>

      <tr>
        <td colspan="3" align="center" valign="middle">
          <el-button type="primary" @click="onSaveProblem">点击提交</el-button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
    export default {
      name: "ClassInformation",
      data(){
        return{
          tableData:{
            className:'1', //班级名
            classQQ:'1',//班级QQ群
            classManifesto:'1',//班级宣言
            department:'1',//所属学院
            teacherName:'1',//老师名字
            teacherPhone:'1',//老师电话
            suggest:'1',//建议
          }
        }
      },

      created() {
        this.classInformation();
      },

      methods:{
        /***
         * 初始化及渲染页面
         */
        classInformation(){
          let that=this;
          let studentNumber=this.$cookie.get('account');
          this.$axios.post("http://localhost:8889/system/student/classInformation",{
            studentNumber:studentNumber,
          }).then(function (res) {
            console.log("班级信息",res);
            that.tableData=res.data.data[0];
          }).catch(function (err) {
            console.log(err);
          })
        },

        /****
         * 提交建议
         */
        onSaveProblem(){
          let className=this.tableData.className;
          let suggest=this.tableData.suggest;
          console.log("建议",className,suggest)
          this.$axios.post("http://localhost:8889/system/student/submitSuggest",{
            className: className,
            suggest:suggest,
          }).then(function (res) {
            console.log("提交建议成功返回",res);
            alert("提交成功！")
          }).catch(function (err) {
            console.log("提交建议失败返回",err)
          })
        },

      }
    }
</script>

<style scoped>
  table td{
    border: 1px solid black;
  }
</style>
