<template>
  <div class="page">
    <div class="Login">
      <font size="7" color="black"><p align="center">系统登录</p></font>
      <el-form :model="ruleFormData" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <div class="formDiv">
          <el-form-item label="账号" prop="account">
            <el-input type="text" v-model="ruleFormData.account"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="passWord">
            <el-input type="password" v-model="ruleFormData.passWord"></el-input>
          </el-form-item>
          <el-radio v-model="ruleFormData.radio" label="student">学生</el-radio>
          <el-radio v-model="ruleFormData.radio" label="teacher">教师</el-radio><p/>
        </div>
        <el-form-item class="loginButton">
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
    export default {
        name: "Login",

        data() {
            return {
                ruleFormData: {
                  account: '',
                  passWord: '',
                  radio: 'student',
                },
                rules: {
                    account: [
                        {required: true, message: '请输入账号', trigger: 'blur'}
                    ],
                    passWord: [
                        { required: true, message: '请输入密码', trigger: 'blur'}
                    ]
                },
            }
        },

        methods: {
          submitForm(ruleForm) {
            this.$refs[ruleForm].validate((valid) => {
              if (valid) {
                let that=this;
                //let params={...this.ruleFormData};
                this.$axios.post('http://localhost:8889/system/student/login',{
                  account:this.ruleFormData.account,
                  passWord:this.ruleFormData.passWord,
                  role:this.ruleFormData.radio
                }).then(function(res){
                  that.$cookie.set("account",res.data.data[0].account);
                  that.$cookie.set("role",res.data.data[0].role);
                  console.log(res);
                  let role=(res.data.data[0].role);
                  let code=(res.data.code)
                  if (role=="student" && code=="200"){
                    that.$router.push({path:"/personalCenter"});
                  }else if (role="teacher") {
                    that.$router.push({path:"/teacherHome"})
                  }
                }).catch(function (error) {
                  that.$message.error("账号或密码错误！");
                  console.log(error);
                });
              }
            });
          }
        }
    }
</script>

<style scoped>
  .Login{
    width: 300px;
    margin:50px auto;
    border:1px solid black;
    border-radius: 15px;
  }
  p{
    margin-bottom: 30px;
    margin-top: 5px;
  }
  .formDiv{
    margin-right: 30px;
  }
  .loginButton{
    margin-left: 90px;
  }

</style>
