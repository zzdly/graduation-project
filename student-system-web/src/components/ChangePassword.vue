<template>
  <div style="margin-left: 10%;margin-top: 10%">
    <div class="app-container common-list-page">
      <el-form :model="resetForm" :rules="resetFormRules" ref="resetForm" status-icon label-width="100px">
        <el-form-item label="旧密码：" prop="password">
          <el-input type="password" v-model="resetForm.password" auto-complete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="新密码：" prop="newpwd">
          <el-input type="password" v-model="resetForm.newpwd" auto-complete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="确认密码：" prop="newpassword1">
          <el-input type="password" v-model="resetForm.newpassword1" auto-complete="off" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item style="margin-top: 66px;margin-left: 18%">
          <el-button type="primary" @click="changePassword">确认修改</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
    export default {
      name:"ChangePassword",
      data() {
        var validatePass = (rule, value, callback) => {
          if (!value) {
            callback(new Error("请输入新密码"));
          } else if (value.toString().length < 6 || value.toString().length > 18) {
            callback(new Error("密码长度为6-18位"));
          } else {
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === "") {
            callback(new Error("请再次输入密码"));
          } else if (value !== this.resetForm.newpwd) {
            callback(new Error("两次输入密码不一致!"));
          } else {
            callback();
          }
        };
        return {
          resetForm: {
            newpwd:"",//新密码
            newpassword1: "", //新密码
            password: "",  //旧密码
          },
          resetFormRules: {
            password: [
              { required: true, message: "请输入旧密码", trigger: 'blur' }
            ],
            newpwd: [
              { required: true, validator: validatePass, trigger: 'blur' }
            ],
            newpassword1: [
              { required: true, validator: validatePass2, trigger: "blur" }
            ]
          }
        };
      },
      methods: {
        changePassword() {
          if (this.resetForm.newpassword1!=this.resetForm.newpwd){
            return false;
          }else {
            console.log(this.resetForm.newpassword1,this.resetForm.password);
          }
        },
      }
    }
</script>

<style scoped>
  .el-form {
    width: 40%;
    text-align: left;
    button {
      margin: 50px 0 0;
    }
  }
</style>
