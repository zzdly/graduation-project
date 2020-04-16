<template>
  <el-container style="height: 750px; border: 1px solid #eee; margin-top: 0px; margin-bottom: 0px"> <!--最外层容器-->

    <el-header style="height: 100px">Header</el-header> <!--头部导航栏-->

    <el-container> <!--第二层外部容器-->
      <el-aside width="200px" >  <!--左侧容器-->
        <el-menu  style="background-color: #D3DCE6" router><!--左侧导航栏--><!--:default-openeds="['1']"-->
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>个人中心</template>
              <el-menu-item index="/personalCenter">基本信息</el-menu-item>
              <el-menu-item index="/classInformation">班级信息</el-menu-item>
              <el-menu-item index="1-2">密码修改</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>成绩中心</template>
              <el-menu-item index="/scoreQuery">成绩查询</el-menu-item>
              <el-menu-item index="2-2">绩点查询</el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>考试中心</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
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
</template>

<script>
    export default {
        name: "Home"
    }
</script>

<style scoped>

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

  /*.el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
   !* line-height: 500px;*!
  }*/
</style>
