<template>
  <section id="login">
    <h1 class="login-title">帐号登录</h1>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="" class="demo-ruleForm">
      
      <el-form-item label="" prop="username">
        <el-input v-model="ruleForm.username"  prefix-icon="el-icon-user" placeholder="账号"></el-input>
      </el-form-item>
      
      <el-form-item label="" prop="password">
        <el-input show-password v-model="ruleForm.password"  prefix-icon="el-icon-lock" placeholder="密码"></el-input>
      </el-form-item>
      
      <el-form-item>
        <el-button class="sccuess-button"  @click="loginForm">登录</el-button>
     <!--    <el-button @click="resetForm('ruleForm')">重置</el-button> -->
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
const axios = require('axios');
const _this=this;
export default {
  name:'login',
  data(){
    return{
      ruleForm: {
          username: '',
          password: '',
      },

      rules: {
          username: [
            { required: true, message: '请输入账号!', trigger: 'blur' },
            { min: 5, max: 18, message: '长度在 5 到 18 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码!', trigger: 'blur' },
            { min: 5, max: 18, message: '长度在 5 到 18 个字符', trigger: 'blur' }
          ],
        }
    }

  },
  methods:{
    
    /**
     * 登录验证处理 
     * */ 
    loginForm(){
      this.$refs.ruleForm.validate(async valid =>{
        if (!valid) return; //验证失败
        const {data:res} =await this.$http.post("/login",this.ruleForm); //访问后台
        console.log(res);
        if (res.flag =="ok") {
          window.sessionStorage.setItem("user",res.user);//session存储 user到主页
          this.$message.success("登录成功!");
          this.$router.push({path:"/"}); //路由跳转
          console.log(res.user);
        }else{
          this.$message.error("账号或密码有误!");         
          console.log("失败!");
        }
      })
    },

    sccuessForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8888/')
              .then(function (response) {
                // 处理成功情况
                if (response.data.code==200) {
                  console.log(response.data);
                }
              })
              .catch(function (error) {
                // 处理错误情况
                console.log(error);
              })
              .then(function () {
                // 总是会执行
              });
            this.$message({
              showClose: true,
              message: '恭喜你，这是一条成功消息',
              type: 'success'
            });
        } else {
          this.$message({
              showClose: true,
              message: '错了哦，这是一条错误消息',
              type: 'error'
          });
          return false;
        } 
      });
    },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
  }
}
</script>

<style  scoped>
  #login{
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
    width: 380px;
    height: 480px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px 1px  rgb(230, 226, 226);
  }
  .login-title{
    margin: 0;
    font-size: 26px;
    transform: translateY(55px);
    font-weight: 500;
    text-align: center;
  }
  .demo-ruleForm{
    transform: translateY(50%);
    width: 300px;
    height: 250px;
    margin: 0 auto;
  }
  el-button {
    height: 50px;
  }
  .sccuess-button{
    width: 300px;
    height: 45px;
    background:  #2ad181;
    color: #fff;
    transform: translateY(55px);
  }
  .sccuess-button:hover{
     background-color: #21a767;
     color: #fff;
  }
</style>