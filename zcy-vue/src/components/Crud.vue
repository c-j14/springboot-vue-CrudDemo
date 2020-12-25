/** * 信息管理 用户信息配置 */
<template>
  <div>
    <!-- 搜索筛选 -->
    <el-form :inline='true' :model='formInline' class='teacher-search'>
      <el-form-item label='搜索：'>
        <el-input
          size='small'
          v-model='formInline.q'
          placeholder='请输入教师名称'
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button
          size='small'
          type='primary'
          icon='el-icon-search'
          @click='search'
          >搜索</el-button
        >
        <el-button
          size='small'
          type='primary'
          icon='el-icon-plus'
          @click="handleEdit('', null, addFlag)"
          >添加</el-button
        >
      </el-form-item>
    </el-form>
    <!--教师信息配置列表-->
    <el-table
      size='small'
      :data='listData'
      highlight-current-row
      v-loading='loading'
      border
      stripe
      element-loading-text='拼命加载中'
      style='width: 100%'
    >
      <el-table-column align='center' type='index' width='60'>
      </el-table-column>
      <el-table-column
        prop='tId'
        label='教师编码'
        width='200'
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        prop='tName'
        label='姓名'
        width='120'
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        prop='tAge'
        label='年龄'
        width='100'
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        prop='tSex'
        label='性别'
        width='100'
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        prop='tAddress'
        label='地址'
        width='100'
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        prop='tSubject'
        label='科目'
        width='100'
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column align='center' label='操作' width='300px'>
        <template slot-scope='scope'>
          <el-button
            size='mini'
            @click='handleEdit(scope.$index, scope.row, editFlag)'
            >编辑</el-button
          >
          <el-button
            size='mini'
            type='danger'
            @click='deleteConfigInfo(scope.$index, scope.row)'
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- 添加 编辑界面 -->
    <el-dialog
      :title='title'
      :visible.sync='editFormVisible'
      width='80%'
      @click="closeDialog('editForm')"
    >
      <el-form
        :inline='true'
        label-width='120px'
        :model='editForm'
        :rules='rules'
        ref='editForm'
      >
        <el-form-item label='教师编码' prop='tId'>
          <el-input
            size='small'
            v-model='editForm.tId'
            auto-complete='off'
            placeholder='请输入教师编码'
          ></el-input>
        </el-form-item>
        <el-form-item label='姓名' prop='tName'>
          <el-input
            size='small'
            v-model='editForm.tName'
            auto-complete='off'
            placeholder='请输入教师姓名'
          ></el-input>
        </el-form-item>
        <el-form-item label='年龄' prop='tAge'>
          <el-input
            size='small'
            v-model.number='editForm.tAge'
            auto-complete='off'
            placeholder='请输入教师年龄'
          ></el-input>
        </el-form-item>
        <el-form-item label='性别' prop='tSex'>
          <el-input
            size='small'
            v-model='editForm.tSex'
            auto-complete='off'
            placeholder='请输入教师性别'
          ></el-input>
        </el-form-item>
        <el-form-item label='地址' prop='tAddress'>
          <el-input
            size='small'
            v-model='editForm.tAddress'
            auto-complete='off'
            placeholder='请输入地址'
          ></el-input>
        </el-form-item>
         <el-form-item label='科目' prop='tSubject'>
          <el-input
            size='small'
            v-model='editForm.tSubject'
            auto-complete='off'
            placeholder='请输入科目'
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot='footer' class='dialog-footer'>
        <el-button size='small' @click="closeDialog('editForm')"
          >取消</el-button
        >
        <el-button
          size='small'
          type='primary'
          :loading='loading'
          class='title'
          @click="submitForm('editForm')"
          >保存</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  TeacherConfigList,
  TeacherConfigAdd,
  TeacherConfigUpdate,
  TeacherConfigDelete
} from '../api/teacherconfigMG'
export default {
  data () {
    var validateTAge = (rule, value, callback) => {
      if (value === '' || value === undefined || value === null) {
        callback()
      } else if (!Number(value)) {
        callback(new Error('请输入[0,200]之间的数字'))
      } else if (value < 0 || value > 200) {
        callback(new Error('请输入[0,200]之间的数字'))
      } else {
        callback()
      }
    }
    var validateTSex = (rule, value, callback) => {
      if (value === '' || value === undefined || value === null) {
        callback()
      } else if (value === '男' || value === '女') {
        callback()
      } else {
        callback(new Error('请输入男或女'))
      }
    }
    return {
      loading: false, // 是显示加载
      editFormVisible: false, // 控制编辑页面显示与隐藏
      editFlag: 'EDIT',
      addFlag: 'ADD',
      isEdit: false,
      title: '添加配置信息',
      startAndEndDate: '',
      editForm: {
        id: '',
        tId: '',
        tName: '',
        tAge: '',
        tSex: '',
        tAddress: '',
        tSubject: ''
      },
      rules: {
        tId: [
          { required: true, message: '请输入教师ID', trigger: 'blur' },
          { min: 1, max: 25, message: '教师编号长度为 1 到 25个字符', trigger: 'blur' }
        ],
        tName: [
          { required: true, message: '请输入教师姓名', trigger: 'blur' },
          { min: 1, max: 25, message: '教师姓名长度为 1 到 25个字符', trigger: 'blur' }
        ],
        tAge: [
          { required: true, message: '请输入年龄', trigger: 'blur' },
          { validator: validateTAge, trigger: 'blur' }
        ],
        tSex: [
          { required: true, message: '请输入性别', trigger: 'blur' },
          { min: 1, max: 25, message: '性别长度为 1 到 10个字符', trigger: 'blur' },
          { validator: validateTSex, trigger: 'blur' }
        ],
        tAddress: [
          { required: true, message: '请输入地址', trigger: 'blur' },
          { min: 1, max: 25, message: '地址长度为 1 到 50个字符', trigger: 'blur' }
        ],
        tSubject: [
          { required: true, message: '请输入科目', trigger: 'blur' },
          { min: 1, max: 25, message: '科目长度为 1 到 25个字符', trigger: 'blur' }
        ]
      },
      formInline: {
        page: 1,
        limit: 10,
        q: ''
      },
      // 删除部门
      seletedata: {
        ids: '',
        token: localStorage.getItem('logintoken')
      },
      // 分页参数
      pageparm: {
        currentPage: 1,
        pageSize: 10,
        total: 0
      }
    }
  },

  /**
   * 创建完毕
   */
  created () {
    this.getdata(this.formInline)
  },

  /**
   * 里面的方法只有被调用才会执行
   */
  methods: {
    // 获取配置列表
    getdata (parameter) {
      this.loading = true
      /***
       * 调用接口
       */
      TeacherConfigList(parameter)
        .then(res => {
          this.loading = false
          if (res.code === 0) {
            this.listData = res.data
          } else {
            this.$message({
              type: 'info',
              message: res.message
            })
          }
        })
        .catch(err => {
          this.loading = false
          console(err)
        })
    },

    // 搜索事件
    search () {
      this.getdata(this.formInline)
    },
    // 显示编辑界面
    handleEdit: function (index, row, handleType) {
      this.editFormVisible = true
      if (handleType === this.editFlag) {
        this.isEdit = true
        if (row !== undefined && row !== 'undefined') {
          this.title = '修改配置信息'
          this.editForm.id = row.id
          this.editForm.tId = row.tId
          this.editForm.tName = row.tName
          this.editForm.tAge = row.tAge
          this.editForm.tSex = row.tSex
          this.editForm.tAddress = row.tAddress
          this.editForm.tSubject = row.tSubject
        }
      } else {
        this.isEdit = false
        this.title = '添加配置信息'
        this.editForm.id = ''
        this.editForm.tId = ''
        this.editForm.tName = ''
        this.editForm.tAge = ''
        this.editForm.tSex = ''
        this.editForm.tAddress = ''
        this.editForm.tSubject = ''
      }
    },
    // 编辑、增加页面保存方法
    submitForm (editData) {
      this.$refs[editData].validate(valid => {
        if (valid) {
          if (this.isEdit) {
            this.updateConfigInfo()
          } else {
            this.addConfigInfo()
          }
        } else {
          return false
        }
      })
    },
    // 更新配置信息
    updateConfigInfo () {
      TeacherConfigUpdate(this.editForm)
        .then(res => {
          this.editFormVisible = false
          this.loading = false
          if (res.code === 0) {
            this.getdata(this.formInline)
            this.$message({
              type: 'success',
              message: '配置信息更新成功！'
            })
          } else {
            this.$message({
              type: 'info',
              message: res.message
            })
          }
        })
        .catch(err => {
          console(err)
          this.editFormVisible = false
          this.loading = false
          this.$message.error('配置信息更新失败，请稍后再试！')
        })
    },
    // 新增配置信息
    addConfigInfo () {
      TeacherConfigAdd(this.editForm)
        .then(res => {
          this.editFormVisible = false
          this.loading = false
          if (res.code === 0) {
            this.getdata(this.formInline)
            this.$message({
              type: 'success',
              message: '配置信息新增成功！'
            })
          } else {
            this.$message({
              type: 'info',
              message: res.message
            })
          }
        })
        .catch(err => {
          console(err)
          this.editFormVisible = false
          this.loading = false
          this.$message.error('配置信息新增失败，请稍后再试！')
        })
    },
    // 删配置信息
    deleteConfigInfo (index, row) {
      this.$confirm('确定要删除吗?', '信息', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          TeacherConfigDelete(row.id)
            .then(res => {
              if (res.code === 0) {
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                })
                this.getdata(this.formInline)
              } else {
                this.$message({
                  type: 'info',
                  message: res.message
                })
              }
            })
            .catch(err => {
              console(err)
              this.loading = false
              this.$message.error('配置信息删除失败，请稍后再试！')
            })
        })
        .catch(err1 => {
          console.log(err1)
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 关闭编辑、增加弹出框
    closeDialog (formName) {
      this.editFormVisible = false
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style scoped>
.teacher-search {
  margin-top: 20px
}
.userRole {
  width: 100%
}
</style>
