<template>
    <div>
        <el-form style="width:60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="书名" prop="name">
                <el-input v-model="ruleForm.name" placeholder="如“Java程序语言设计”"></el-input>
            </el-form-item>
            <el-form-item label="作者" prop="author">
                <el-input v-model="ruleForm.author" placeholder="如“张三”"></el-input>
            </el-form-item>
            <el-form-item label="出版社" prop="publish">
                <el-input v-model="ruleForm.publish" placeholder="如“人民出版社”"></el-input>
            </el-form-item>
            <el-form-item label="书本总页数" prop="pages">
                <el-input v-model="ruleForm.pages" placeholder="如“123”"></el-input>
            </el-form-item>
            <el-form-item label="价格" prop="price">
                <el-input v-model="ruleForm.price" placeholder="如“123”"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button id="primary" type="primary">
                    <router-link to="/page1">回到首页</router-link>
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>


<script>
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          author:'',
          publish:'',
          pages:'',
          price:'',
          type: [],
        },
        rules: {          
          name: [
            { required: true, message: '请输入书名', trigger: 'blur' },
            { min: 1, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur' },
          ],
          author:[
            { required: true, message: '请输入书名的作者', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' },
          ],
          publish:[
            { required: true, message: '请输入出版社', trigger: 'blur' },
            { min: 1, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' },
          ],
          pages:[
            { required: true, message: '请输入书本的总页数', trigger: 'blur' },
            { min: 1, max: 5000, message: '长度在 1 到 5000 页', trigger: 'blur' },
          ],
          price:[
            { required: true, message: '请输入书本的出售价格', trigger: 'blur' },
            { min: 1, max: 99999, message: '长度在 1 到 9999 个字符', trigger: 'blur' },
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        const _this=this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8081/save',this.ruleForm).then(function(resp){
   
                if (resp.data =='success') {
                    _this.$message({
                        message: '添加成功',
                        type: 'success'
                    });
                }
            })
  
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },

    }
  }
</script>


<style scoped>

    a{
        text-decoration: none;
        list-style: none;
        color: aliceblue;
    }
</style>