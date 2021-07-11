<template>
  <div>
    <el-table
      :data="
        tableData.filter(
          (data) =>
            !search || data.name.toLowerCase().includes(search.toLowerCase()))" style="width: 85%">
      <el-table-column label="编号" prop="id"> </el-table-column>
      <el-table-column label="图书名称" prop="name"> </el-table-column>
      <el-table-column label="作者" prop="author"> </el-table-column>
      <el-table-column label="出版社" prop="publish "> </el-table-column>
      <el-table-column label="页面" prop="pages"> </el-table-column>
      <el-table-column label="价格" prop="price"> </el-table-column>

      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="updateOpen(scope.$index, scope.row)">修改</el-button>
          
          <el-button size="mini" type="danger" @click="deleteOpen(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      background
      layout="prev, pager, next"
      page-size="10"
      :total="50"
      @current-change="page"
    >
    </el-pagination>
  </div>
</template>


<script>
export default {
  name: "Book",
  methods: {
    page(currentPage) {
      const _this = this;
      axios
        .get("http://localhost:8081/findAll/" + currentPage + "/10")
        .then(function (resp) {
          _this.tableData = resp.data.content;
          _this.total = resp.data.totalElements;
          console.log(resp);
        });
    },

    deleteOpen(index, row) {
      const _this = this;
      axios
        .delete("http://localhost:8081/deleteById/" + row.id)
        .then(function (resp) {
          _this.$message({
            message: "删除成功",
            type: "success",
          });
          setTimeout(function () {
            window.location.reload();
          }, 1500);
        });
    },

    updateOpen(index, row) {
      this.$router.push({
        path:'/page3',
        query:{
          id:row.id
        }
      })
    },
  },

  created() {
    const _this = this;
    axios.get("http://localhost:8081/findAll/1/10").then(function (resp) {
      _this.tableData = resp.data.content;
      _this.total = resp.data.totalElements;
      console.log(resp);
    });
  },

  data() {
    return {
      total: null,
      tableData: null,
    };
  },
};
</script>
<style scoped>
table {
  border-collapse: collapse;
}
tr,
td {
  width: 250px;
  height: 50px;
  border: 1px solid rgb(223, 217, 217);
}
</style>