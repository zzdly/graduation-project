<template>
  <div style="margin-left: 15px;margin-top: 15px">
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
          <textarea name="problemContent" id="problemContent" cols="120" rows="8" class="input_2">{{this.tableData.suggest}}</textarea>
        </td>
      </tr>

      <tr>
        <td colspan="3" align="center" valign="middle">
          <input type="button" name="button2" id="button2" value="点击提交" class="input2" onclick="onSaveProblem()" />
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


      }
    }
</script>

<style scoped>
  table td{
    border: 1px solid black;
  }
</style>
