<template>
  <div>
    <el-form
      style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="书名" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publish">
        <el-input v-model="ruleForm.publish"></el-input>
      </el-form-item>
      <el-form-item label="书本总页数" prop="pages">
        <el-input v-model="ruleForm.pages"></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model="ruleForm.price"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="updateOpen('ruleForm')">修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


<script>
export default {
  data() {
    return {
      ruleForm: {
        name: "",
        author: "",
        publish: "",
        pages: "",
        price: "",
        type: [],
      },
      rules: {
        name: [
          { required: false, message: "请输入书名", trigger: "blur" },
          {
            min: 1,
            max: 50,
            message: "长度在 3 到 50 个字符",
            trigger: "blur",
          },
        ],
        author: [
          { required: false, message: "请输入书名的作者", trigger: "blur" },
          {
            min: 1,
            max: 20,
            message: "长度在 3 到 20 个字符",
            trigger: "blur",
          },
        ],
        publish: [
          { required: false, message: "请输入出版社", trigger: "blur" },
          {
            min: 1,
            max: 15,
            message: "长度在 3 到 15 个字符",
            trigger: "blur",
          },
        ],
        pages: [
          { required: false, message: "请输入书本的总页数", trigger: "blur" },
          {
            min: 1,
            max: 5000,
            message: "长度在 1 到 5000 页",
            trigger: "blur",
          },
        ],
        price: [
          { required: false, message: "请输入书本的出售价格", trigger: "blur" },
          {
            min: 1,
            max: 99999,
            message: "长度在 1 到 9999 个字符",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    updateOpen(formName) {
      const _this = this;
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios
            .put("http://localhost:8081/update", this.ruleForm)
            .then(function (resp) {
              if (resp.data == "success") {
                _this.$message({
                  message: "修改成功",
                  type: "success",
                });
                _this.$router.push("/page1")
              }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  created() {
    const _this = this;
    axios
      .get("http://localhost:8081/findById/" + _this.$route.query.id)
      .then(function (resp) {
        _this.ruleForm = resp.data;
      });
  },
};
</script>


<style scoped>
a {
  text-decoration: none;
  list-style: none;
  color: aliceblue;
}
</style>