<template>
  <div>
    <el-container style="height: 780px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: ">
        <el-menu :default-openeds="['1', '3']" default-active="1-1">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-setting"></i>管理</template>
            <el-menu-item-group>
              <el-menu-item index="1-1">
                <router-link to="/page1">查询</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link to="/page2">添加</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>

        <el-main>
          <router-view />

        </el-main>

      </el-container>
    </el-container>

  </div>
</template>

<script>
export default {


};
</script>

<style scoped>
  .el-header {
    background-color:rgb(84, 92, 100);
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }

  a{
    width: 200px;
    display: block;
    transform: translateX(-40px);
    text-decoration: none;
    color: #333;
  }
  a:hover{
    color:  rgb(255, 208, 75);

  }
</style>