# Paging library for Abilists
--------------------------------------------------

\[ [About](https://github.com/abilists/paging) •
[Install](https://github.com/abilists/paging) • [Blog](http://njoonk.blogspot.jp/) \]

[![Build Status](https://travis-ci.org/abilists/paging.svg?branch=master)](https://travis-ci.org/abilists/paging)
![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/abilists/paging)


Paging is a library to divide pages in Java. It is very sample so you can easily use it to your
particular web project.

#### About
Paging has a few special features:

* Just 3 or 5 line coding in Java
* Make pagination with limiter and range
* Handy integration with view
#### Runtime Requirements

- *P1:* Java8 or newer
- *P2:* Junit test

#### How to Install
Build as blow
```
$ gradle install
```
Add the following code into build.gradle in your new project.
```
compile 'io.paging:paging:0.2'
```
#### Get started
Add the following code into the Model class.
```
private PagingBean paging;
public PagingBean getPaging() {
	return paging;
}
public void setPaging(PagingBean paging) {
	this.paging = paging;
}
```
Caculate a sum and set it to the paging
```
abilistsModel.setPaging(service.makePaging(tasksPara, intSum));
```
Caculate a sum and set it to the paging
```
List<abilistsModel> abilistsList = projectService.listAbilists(tasksPara);
abilistsModel.setAbilistsList(abilistsList);

```
Add the following code into View page
```
<nav class="text-center">
    <ul class="pagination">
    <#if model?exists>
  	<#if model.paging?exists>
		<#if model.paging.prevPage?exists>
		<li><a href="abilistsList?nowPage=${model.paging.prevPage.nowPage}&allCount=${model.paging.allCount?c}" title="Prev" accesskey="*">Prev</span></a></li>
		</#if>
		<#if model.paging.pagingInfoList?has_content>
			<#list model.paging.pagingInfoList as pageList>
				<#if model.paging.nowPage?if_exists == pageList.pageNumber?if_exists>
				<li class="active"><a href="#">${pageList.pageNumber} <span class="sr-only">(current)</span></a></li>
				<#else>
				<li><a href="abilistsList?nowPage=${pageList.pageNumber}&allCount=${model.paging.allCount?c}">${pageList.pageNumber}</a></li>
				</#if>
			</#list>
		</#if>
		<#if model.paging.nextPage?exists>
		<li><a href="abilistsList?nowPage=${model.paging.nextPage.nowPage}&allCount=${model.paging.allCount?c}" accesskey="#" title="Next">Next</a></li>
		</#if>
	</#if>
	</#if>
  	</ul>
</nav>
```
#### License

Paging is distributed under the MIT License.


#### Thank you!

I really appreciate all kind of feedback and contributions. Thanks for using and supporting Paging!
