<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"src="js/jtopo-0.4.8-min.js"></script>
	<script type="text/javascript"src="js/jquery-1.7.2.min.js"></script>
	<script id='code'>
		$(document).ready(function(){
		
		
		document.getElementById("birthdayDiv").style.display="none";
		document.getElementById("discoDiv").style.display="none";
		document.getElementById("slrDiv").style.display="none";
		document.getElementById("slsDiv").style.display="none";
		document.getElementById("uconnDiv").style.display="none";
		
		
		function newNode(x, y){
                var node = new JTopo.Node();
                node.setLocation(x, y);
                node.dragable = "fales";
                node.setSize("10", "10");
                scene.add(node);
                return node;
            }
            
            // 简单连线
            function newLink(nodeA, nodeZ, text, dashedPattern){
                var link = new JTopo.Link(nodeA, nodeZ, text);        
                link.lineWidth = 3; // 线宽
                link.dashedPattern = dashedPattern; // 虚线
                link.bundleOffset = 60; // 折线拐角处的长度
                link.bundleGap = 20; // 线条之间的间隔
                link.textOffsetY = 3; // 文本偏移量（向下3个像素）
                link.strokeColor = '0,200,255';
                scene.add(link);
                return link;
            }
		var canvas = document.getElementById('canvas');            
            var stage = new JTopo.Stage(canvas);
            var scene = new JTopo.Scene(stage);
		 var array = new Array();
		 
		   <c:forEach items="${posPair}" var="a">
  				array.push("${a}");
  				
			</c:forEach>
			var strs;
			for(var i=0;i<array.length;i++){
 				var link = array[i];
 				
 				strs=link.split("=");
 				
 				pos1=strs[0].split(",");
 				pos2=strs[1].split(",");
 				var x1 = pos1[0];
 				var y1 = pos1[1];
 				var x2 = pos2[0];
 				var y2 = pos2[1];
 				
 				var ix1 = parseInt(x1);
 				var iy1 = parseInt(y1);
 				var ix2 = parseInt(x2);
 				var iy2 = parseInt(y2);
 				
 				var node1 = newNode(ix1*5,iy1*5);
 				var node2 = newNode(ix2*5,iy2*5);
 				newLink(node1,node2);
 				
 				
 				
 				
 				
 				 
			}
			
			
           
           
            
            
            
           
           
        });
        
        function showBirthday(){
		
				document.getElementById("birthdayDiv").style.display="";

			}
	</script>
	<script type="text/javascript">
	 function showBirthday(){
			
				document.getElementById("birthdayDiv").style.display="";
				document.getElementById("discoDiv").style.display="none";
				document.getElementById("slrDiv").style.display="none";
				document.getElementById("slsDiv").style.display="none";
				document.getElementById("uconnDiv").style.display="none";

			}
	
	 function showDisco(){
			
				document.getElementById("birthdayDiv").style.display="none";
				document.getElementById("discoDiv").style.display="";
				document.getElementById("slrDiv").style.display="none";
				document.getElementById("slsDiv").style.display="none";
				document.getElementById("uconnDiv").style.display="none";

			}
			
			
	function showSLR(){
			
				document.getElementById("birthdayDiv").style.display="none";
				document.getElementById("discoDiv").style.display="none";
				document.getElementById("slrDiv").style.display="";
				document.getElementById("slsDiv").style.display="none";
				document.getElementById("uconnDiv").style.display="none";

			}
			
	function showSLS(){
			
				document.getElementById("birthdayDiv").style.display="none";
				document.getElementById("discoDiv").style.display="none";
				document.getElementById("slrDiv").style.display="none";
				document.getElementById("slsDiv").style.display="";
				document.getElementById("uconnDiv").style.display="none";

			}
			
	function showUconn(){
			
				document.getElementById("birthdayDiv").style.display="none";
				document.getElementById("discoDiv").style.display="none";
				document.getElementById("slrDiv").style.display="none";
				document.getElementById("slsDiv").style.display="none";
				document.getElementById("uconnDiv").style.display="";

			}
	
	</script>
  </head>
  
  
  <body>
   <center>
   	<div style=" margin:30px auto;">
   		<input type="button" value="birthday" onClick="showBirthday()">
   		<input type="button" value="disco" onClick="showDisco()">
   		<input type="button" value="searchLight-R" onClick="showSLR()">
   		<input type="button" value="searchLight-S" onClick="showSLS()">
   		<input type="button" value="uconnect" onClick="showUconn()">
   	</div>
   	<div id="birthdayDiv" style=" margin:30px auto;">
   		<form class="form" action="servlet/BirthdayServlet" method="get">
    		<div class="form-group">
        		<label class="label form-control">结点数目</label>
        		<input type="text" class="form-control" name="node_num">
   			</div>
    		<div class="form-group">
        		<label class="form-control">
            		<input class="btn btn-default" type="submit" value="确认">
        		</label>
    	</div>

		</form>
   	</div>
   	
   	<div id="discoDiv" style=" margin:30px auto;">
   		<form class="form" action="servlet/DiscoServlet" method="get">
    		<div class="form-group">
        		<label class="label form-control">素数1</label>
        			<input type="text" class="form-control" name="prime1">
    		</div>
    		<div class="form-group">
        		<label class="label form-control">素数2</label>
        			<input type="text" class="form-control" name="prime2">
    		</div>
    		<div class="form-group">
        		<label class="form-control">
           	 		<input class="btn btn-default" type="submit" value="确认">
        		</label>
    		</div>

		</form>
   	</div>
   	
   	<div id="slrDiv" style=" margin:30px auto;">
   		<form class="form" action="servlet/SearchLightRServlet" method="get">
    		<div class="form-group">
        		<label class="label form-control">时间间隔</label>
        			<input type="text" class="form-control" name="time">
    		</div>
   		 	<div class="form-group">
        		<label class="form-control">
            		<input class="btn btn-default" type="submit" value="确认">
        		</label>
    		</div>

		</form>
   	</div>
   	
   	<div id="slsDiv" style=" margin:30px auto;">
   		<form class="form" action="servlet/SearchLightSServlet" method="get">
    		<div class="form-group">
        		<label class="label form-control">时间间隔</label>
        		<input type="text" class="form-control" name="time">
    		</div>
    		<div class="form-group">
        		<label class="form-control">
            		<input class="btn btn-default" type="submit" value="确认">
        		</label>
    		</div>

		</form>
   	</div>
   	
   	<div id="uconnDiv" style=" margin:30px auto;">
   		<form class="form" action="servlet/UConnServlet" method="get">
			<div class="form-group">
    			<label class="label form-control">素数</label>
    				<input type="text" class="form-control" name="prime">
			</div>
			<div class="form-group">
    			<label class="form-control">
        			<input class="btn btn-default" type="submit" value="确认">
    			</label>
			</div>

		</form>
   	</div>
   	
		<canvas width="800" height="500" id="canvas" style=" background-color:#EEEEEE; border:1px solid #444;">
		</canvas>
		
		<div style=" margin:30px auto;">
			latency : ${latency};&nbsp&nbsp
			algorithm : ${type};&nbsp&nbsp
			parameter : ${paramter}
		</div>
		
		<c:if test="${type=='birthday'}">
			<form class="form" action="servlet/BirthdayServlet" method="get">
    		<div class="form-group">
        		<input style="visibility:hidden" type="text" class="form-control" name="node_num" value="${paramter}">
   			</div>
    		<div class="form-group">
        		<label class="form-control">
            		<input class="btn btn-default" type="submit" value="重试">
        		</label>
    	</div>

		</form>
		</c:if>
		
		<c:if test="${type=='disco'}">
			<form class="form" action="servlet/DiscoServlet" method="get">
    		<div class="form-group">
        		<%String p = (String)request.getAttribute("paramter");
        		String[] strs = p.split(",");
        		 %>
        			<input style="visibility:hidden" type="text" class="form-control" name="prime1" value="<%=strs[0] %>">
    		</div>
    		<div class="form-group">
        		
        			<input style="visibility:hidden" type="text" class="form-control" name="prime2" value="<%=strs[1] %>">
    		</div>
    		<div class="form-group">
        		<label class="form-control">
           	 		<input class="btn btn-default" type="submit" value="重试">
        		</label>
    		</div>

		</form>
		</c:if>
		
		<c:if test="${type=='searchLight-R'}">
			<form class="form" action="servlet/SearchLightRServlet" method="get">
    		<div class="form-group">
        		
        			<input style="visibility:hidden" type="text" class="form-control" name="time" value="${paramter}">
    		</div>
   		 	<div class="form-group">
        		<label class="form-control">
            		<input class="btn btn-default" type="submit" value="重试">
        		</label>
    		</div>

		</form>
		</c:if>
		
		<c:if test="${type=='searchLight-S'}">
			<form class="form" action="servlet/SearchLightSServlet" method="get">
    		<div class="form-group">
        		
        		<input style="visibility:hidden" type="text" class="form-control" name="time" value="${paramter}">
    		</div>
    		<div class="form-group">
        		<label class="form-control">
            		<input class="btn btn-default" type="submit" value="重试">
        		</label>
    		</div>

		</form>
		</c:if>
		
		<c:if test="${type=='searchLight-S'}">
			<form class="form" action="servlet/UConnServlet" method="get">
			<div class="form-group">
    			
    				<input style="visibility:hidden" type="text" class="form-control" name="prime" value="${paramter}">
			</div>
			<div class="form-group">
    			<label class="form-control">
        			<input class="btn btn-default" type="submit" value="重试">
    			</label>
			</div>

		</form>
		</c:if>
		
	</center>
  </body>
</html>
