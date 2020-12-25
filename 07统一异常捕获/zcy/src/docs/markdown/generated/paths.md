
<a name="paths"></a>
## Paths

<a name="druidstatusingget"></a>
### 获取 Druid 的监控数据
```
GET /api/druid-stat
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 教师信息管理


<a name="addusingpost"></a>
### 新增一条教师信息
```
POST /api/teacher/add
```


#### Description
根据Teacher对象创建用户


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**teacher**  <br>*required*|教师详细实体teacher|[Teacher](#teacher)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 教师信息管理


<a name="deletebyidusingdelete"></a>
### 删除教师信息
```
DELETE /api/teacher/delete_teacher_by_id
```


#### Description
根据url的id来删除教师信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**id**  <br>*required*|id|integer (int32)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* 教师信息管理


<a name="deleteteacherbytidusingpost"></a>
### 删除教师信息
```
POST /api/teacher/delete_teacher_by_teacher_id
```


#### Description
根据Teacher对象的的tid来删除教师信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**teacher**  <br>*required*|teacher|[Teacher](#teacher)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|No Content|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 教师信息管理


<a name="listusingpost"></a>
### 获取教师信息列表
```
POST /api/teacher/list
```


#### Description
根据url的q来查询教师信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**q**  <br>*required*|查询值|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 教师信息管理


<a name="queryteacherbytidusingpost"></a>
### 获取教师信息
```
POST /api/teacher/query_teacher_by_t_id
```


#### Description
根据Teacher对象的tid来查询教师信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**teacher**  <br>*required*|teacher|[Teacher](#teacher)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Teacher](#teacher)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 教师信息管理


<a name="updateteacherbytidusingpost"></a>
### 修改教师信息
```
POST /api/teacher/update_teacher_by_teacher_tid
```


#### Description
根据Teacher对象的id来修改教师信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**teacher**  <br>*required*|teacher|[Teacher](#teacher)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 教师信息管理



