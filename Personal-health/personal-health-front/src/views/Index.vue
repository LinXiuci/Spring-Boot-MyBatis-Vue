<template>
  <el-container id="index-container">
    <el-header>
   
      <router-link class="logo" to="/">
        <img src="../assets/logo.png" alt="logo" />
        <span>个人运动平台</span>
      </router-link>

      <router-link to="/Login">登录</router-link>
      <el-button round @click="loginOut">退出</el-button>
    </el-header>

    <el-container>
      <el-aside :width="istoggleButton?'64px':'200px'">

        <div class="toggle-button" @click="toggleButton">|||</div>

        <el-menu  :router="true" :default-active="activePath" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" :collapse="istoggleButton" :collapse-transition="false">
          
          <el-submenu :index="item.id+''" v-for="item in menus" :key="item.id">
            
            <template slot="title">
              <i :class="icon[item.id]"></i>
              <span>{{item.title}}</span>
            </template>
          
            <el-menu-item :index="it.path" @click="saveNavState(it.path)" v-for="it in item.subMenuslList" :key="it.id">
              <template slot="title">
              <i :class="icon[it.id]"></i>
              <span>{{it.title}}</span>
            </template>
            </el-menu-item>
           
          </el-submenu>
        </el-menu>
      </el-aside>

      <!-- 内容展示 -->
      <el-main>
        <router-view />
      </el-main>

    </el-container>

  </el-container>
</template>

<script>
import Login from "../components/Login.vue";
export default {
  components: {
    Login,
  },
  data(){
      return{
          menus:[], //菜单列表
          istoggleButton:false,//侧边栏控制伸缩属性
          icon:{
            '100':'el-icon-key',
            '200':'el-icon-bicycle',
            '101':'el-icon-user',
            '102':'el-icon-edit',
            '103':'el-icon-medal-1',
            '104':'el-icon-shopping-bag-2',
            '201':'el-icon-edit-outline',
            '202':'el-icon-loading',
            '203':'el-icon-fork-spoon',
            '204':'iconfont icondenglu',
          },
          activePath:'/',//默认路径
      }
  },
  methods: {
    
    /* 用户退出 */
    loginOut() {
      window.sessionStorage.clear(); //清除session
      this.$router.push("/login");
    },

    /* 获取菜单列表 */
    async getMenus(){
        const {data:res}= await this.$http.get("/getmainmenuall");
        console.log(res);
        if (res.flag != 200) {
          return this.$message.error("获取列表失败!");
        }else{
          this.menus=res.menus;
        }
    },

    /* 侧边栏控制伸缩 */
    toggleButton(){
      this.istoggleButton=!this.istoggleButton;
    },

    /* 保存路径 */
    saveNavState(activePath){
      window.sessionStorage.setItem('activePath',activePath);
      this.activePath=activePath;
    }
  },
  created(){
      this.getMenus();
      this.activePath=window.sessionStorage.getItem('activePath');
  }
};
</script>

<style scoped>
#index-container {
  /* background:#ffffff; */
  /*   width: 100%; */
  height: 100vh;
}

.el-header {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  color: #f2f2f3;
  font-weight: 600;
  background: #373d41;
}
.el-aside {
  background: #333744;
}
.el-main {
  background: #eaedf1;
 
}
.el-menu{
 border-right: none;
}
.logo{
  color: #fff;
}
.logo img {
  width: 45px;
  height: 45px;
}
.toggle-button{
  background: #4A5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
</style>