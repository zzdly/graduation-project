<template>
  <div class="homeBox">
    <el-container direction="vertical" style="height: 100%; border: 1px solid #eee;"> <!--最外层容器 margin-top: 0px; margin-bottom: 0px-->

      <el-header style="height: 10%;"><!--头部导航栏-->
        <el-row align="middle">

          <el-col :span="2">
            <div class="grid-content bg-purple-light" style="text-align: right;margin-top: 5%;margin-right: 15%">
              <el-image
                style="width: 100px; height: 80px;border-radius:4px"
                src="static/img/img.jpg"
                fit="fit"></el-image>
            </div>
          </el-col>
          <el-col :span="10" style="text-align: left;margin-top: 2%">
            <div class="grid-content bg-purple-light">
              <strong><font size="4">学生信息管理系统（教师端）</font></strong>
            </div>
          </el-col>

          <el-col :span="12">
            <div class="grid-content bg-purple-light" style="text-align: right;margin-top: 2%">
              <span>
                <el-dropdown size="medium" style="margin-top: 2%;">
                  <i class="el-icon-setting" style="margin-right: 10px"></i>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="updatePass" >修改密码</el-dropdown-item>
                    <el-dropdown-item @click.native="exitLogin">退出</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
                <span>账号: {{this.account}}</span>
              </span>
            </div>
          </el-col>
        </el-row>
      </el-header>

      <el-container style="height: auto"> <!--第二层外部容器-->
        <el-aside width="15%" >  <!--左侧容器-->
          <el-menu  style="background-color: #D3DCE6" router><!--左侧导航栏--><!--:default-openeds="['1']"-->
            <el-menu-item index="">基本信息</el-menu-item>
            <el-menu-item index="">成绩管理</el-menu-item>
            <el-menu-item index="">通知管理</el-menu-item>
          </el-menu> <!--左侧导航栏结束-->
        </el-aside> <!--左侧容器结束-->

        <el-container>  <!--第三层外部容器-->
          <el-main>
            <router-view class="router-view-content"/>
          </el-main> <!--主内容-->
          <el-footer>Footer</el-footer> <!--尾部-->
        </el-container>

      </el-container> <!--第二层外部容器结束-->
    </el-container> <!--第一层外部容器结束-->
  </div>
</template>

<script>
    export default {
        name: "TeacherHome",
        data(){
          return{
            account:''
          }
        },
        created() {
          this.account=this.$cookie.get("account");
        },
        methods:{
          updatePass(){
            //this.$router.push({path:"/changePassword"})
          },
          exitLogin(){
            this.$cookie.set("account","");
            this.$cookie.set("role","");
            this.$router.push({path:"/"});
          },
        }
    }
</script>

<style scoped>

  .user-avator {
    margin-right: 20px;

  }
  .user-avator img {
    display: block;
    width: 60px;
    height: 60px;
    border-radius: 50%;
    align-items: center;
    margin-top: 5px;
    margin-right: 10px;
  }

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    /*line-height: 100px;*/
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    /*line-height: 300px;*/
  }


</style>
<style>
  /*
    找到html标签、body标签，和挂载的标签
    都给他们统一设置样式
  */
  html,body,#app,.homeBox,.el-container{
    /*设置内部填充为0，几个布局元素之间没有间距*/
    padding: 0px;
    /*外部间距也是如此设置*/
    margin: 0px;
    /*统一设置高度为100%*/
    height: 100%;
  }
</style>
