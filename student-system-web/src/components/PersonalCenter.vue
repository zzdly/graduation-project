<template>
  <div>
    <div class="personalTable" style="margin-left: 15px;margin-top: 15px">
      <table width="80%" height="500" cellpadding="0" cellspacing="0">
        <tr>
          <td align="right" width="10%">姓名：</td>
          <td width="25%">{{tableData.name}}</td>
          <td align="right" width="10%">身份证号码：</td>
          <td width="25%">{{tableData.cardId}}</td>
          <td rowspan="9"><div align="center"><img id="pic_face"  height="310px" width="80%" style="padding:2px 2px 5px; border:1px #ddd solid;"></div>&nbsp;</td>
        </tr>
        <tr>
          <td align="right">性别：</td>
          <td>{{tableData.gender}}</td>
          <td align="right">学号：</td>
          <td>{{tableData.studentNumber}}</td>
        </tr>
        <tr>
          <td align="right">学历：</td>
          <td>{{tableData.educationBackground}}</td>
          <td align="right">二级院校：</td>
          <td>{{tableData.secondSchool}}</td>
        </tr>
        <tr>
          <td align="right">专业：</td>
          <td>{{tableData.major}}</td>
          <td align="right">班级：</td>
          <td>{{tableData.classId}}</td>
        </tr>

        <tr>
          <td align="right">入学时间：</td>
          <td>{{tableData.startTime}}</td>
          <td align="right">状态：</td>
          <td>{{tableData.schoolRollState}}</td>
        </tr>

        <tr>
          <td colspan="4" align="center">联系方式（如联系方式有变动请及时修改，以便能及时联系到你。谢谢！）</td>
        </tr>
        <tr>
          <td align="right">手机号码：</td>
          <td><input v-model="tableData.phoneNumber"></input></td>
          <td align="right">第二联系号码：</td>
          <td><input v-model="tableData.secondPhoneNumber"></input></td>
        </tr>
        <tr>
          <td align="right">QQ:</td>
          <td><input v-model="tableData.qq"></input></td>
          <td align="right">电子邮箱：</td>
          <td><input v-model="tableData.email"></input></td>

        </tr>
        <tr>
          <td align="right">联系地址：</td>
          <td colspan="4"><input v-model="tableData.addr"></td>
        </tr>
        <tr align="center">
          <td colspan="5" height="40">
            <div align="center">
              <el-button type="info" @click="submitMail">修改联系方式</el-button>
              <!--<input type="button" id="button2" value="联系方式有修改" @onclick="submitMail" class="input2" />-->
            </div>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
    export default {
        name: "PersonalCenter",
        data() {
          return{
            tableData:{
              name:'',//姓名
              cardId:'',//身份证号
              gender:'',//性别
              studentNumber:'',//学号
              educationBackground:'',//学历
              secondSchool:'',//二级院校
              major:'',//专业
              classId:'',//班级
              startTime:'',//入学时间
              schoolRollState:'',//学籍状态
              phoneNumber:'',//联系电话
              secondPhoneNumber:'',//第二联系电话
              qq:"",//QQ
              email:'',//邮箱
              addr:'',//住址
            }
          }
        },

        created() {
          this.personalQuery();
        },

        methods:{
          /*
          * 修改联系方式
          * */
          submitMail(){
            if ((this.$cookie.get('odlphoneNumber')!=this.tableData.phoneNumber) ||
                (this.$cookie.get('odlsecondPhoneNumber')!=this.tableData.secondPhoneNumber)||
                (this.$cookie.get('odlqq')!=this.tableData.qq)||
                (this.$cookie.get('odlemail')!=this.tableData.email)||
                (this.$cookie.get('odladdr')!=this.tableData.addr)){
              let account=this.$cookie.get('account');
              this.$axios.post('http://localhost:8889/system/student/updateContactWay',{
                account:account,
                phoneNumber:this.tableData.phoneNumber,
                secondPhoneNumber:this.tableData.secondPhoneNumber,
                QQ:this.tableData.qq,
                email:this.tableData.email
              }).then(function (res) {
                alert("修改成功！")
                console.log("修改联系方式",res);
                this.personalQuery();
              }).catch(function (err) {
                console.log(err);
              })
            }else {
              alert("联系方式没改动！")
            }

          },

          /*
          * 初始化及渲染表格信息
          * */
          personalQuery(){
            let that=this;
            let account=this.$cookie.get('account');
            this.$axios.post('http://localhost:8889/system/student/personalInformation',{
              account:account
            }).then(function (res) {
              console.log(res);
              that.tableData=res.data.data[0];
              that.odlConcetway(res.data.data[0].phoneNumber,res.data.data[0].secondPhoneNumber,res.data.data[0].qq,res.data.data[0].email,res.data.data[0].addr);
            }).catch(function (err) {
              console.log(err);
            });
          },

          odlConcetway(phoneNumber,secondPhoneNumber,qq,email,addr){
            this.$cookie.set("odlphoneNumber",phoneNumber);
            this.$cookie.set("odlsecondPhoneNumber",secondPhoneNumber);
            this.$cookie.set("odlqq",qq);
            this.$cookie.set("odlemail",email);
            this.$cookie.set("odladdr",addr);
          }
        }
    }
</script>

<style scoped>
  table td{
    border: 1px solid black;
  }
  input{
    text-align: center;
    height: 100%;
    width: 100%;
    border: none;
  }
  #button2{
    width: 110px;
    background-color: grey;
    border: 2px;
    border-color:#B3C0D1;
  }
</style>
