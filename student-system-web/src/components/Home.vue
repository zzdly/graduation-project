<template>
  <div class="homeBox">
    <el-container direction="vertical" style="height: 100%; border: 1px solid #eee;"> <!--最外层容器 margin-top: 0px; margin-bottom: 0px-->

      <el-header style="height: 10%;"><!--头部导航栏-->
        <el-row>

          <el-col :span="12">
            <div class="grid-content bg-purple" style="text-align: left;margin-top: 3%">
              123
            </div>
          </el-col>

          <el-col :span="12">
            <div class="grid-content bg-purple-light" style="text-align: right;margin-top: 2%">
              <span>
                <el-dropdown size="medium" style="margin-top: 2%;">
                  <i class="el-icon-setting" style="margin-right: 10px"></i>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="updatePass" >修改密码</el-dropdown-item>
                    <el-dropdown-item>退出</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
                <span>学号: {{this.account}}</span>
              </span>
            </div>
          </el-col>
        </el-row>




      </el-header>

      <el-container style="height: auto"> <!--第二层外部容器-->
        <el-aside width="15%" >  <!--左侧容器-->
          <el-menu  style="background-color: #D3DCE6" router><!--左侧导航栏--><!--:default-openeds="['1']"-->
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-message"></i>个人中心</template>
              <el-menu-item index="/personalCenter">基本信息</el-menu-item>
              <el-menu-item index="/classInformation">班级信息</el-menu-item>
              <el-menu-item index="/changePassword">密码修改</el-menu-item>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title"><i class="el-icon-menu"></i>成绩中心</template>
              <el-menu-item index="/scoreQuery">成绩查询</el-menu-item>
              <el-menu-item index="/gardePointAverageQuery">绩点查询</el-menu-item>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title"><i class="el-icon-setting"></i>通知中心</template>
              <el-menu-item index="/collegeInform">学院通知</el-menu-item>
              <el-menu-item index="/classInform">班级通知</el-menu-item>
              <el-menu-item index="/examInform">考试通知</el-menu-item>
            </el-submenu>
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
        name: "Home",
        data(){
          return{
            account:''
          }
        },

        created() {
            this.account='16101010513'
        },
        methods:{
          updatePass(){
            this.$router.push({path:"/changePassword"})
          },
        },
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
