<%@page import="model.Bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/stype.css">
    <link rel="stylesheet" href="./fonts/themify-icons/themify-icons.css">
    <title>Document</title>
</head>

<body>
    <div id="Main">
       
        <div class="header">
            
          <div class="logochu">
              <p class="p2">The world's number one file converter</p>
              <p class="p1">Fast, convenient, different experience  </p>
            
          </div >
          <div>
          <div class="dangnhap">
            <ul class="ul">
                <p> <button  class="js-button-buy">Sign in</button> </p>
                <p><button  class="js-button-buy1">Sign up</button></p>
                
            </ul>
              
          </div>
        
        </div>
        </div>

       <div id="head1">
           
 			<div class="welcome">
            <h1 class="w">Welcome to the world of converters</h1>
            <p class="w1">Start registration and experience now</p>
            <button class="bttn js-button-buy1">
                Sign up
            </button>
        </div>
 
     </div>
    </div>
       
        
    
    
   
    </div>
    <%
		Account a = (Account)request.getSession().getAttribute("account");
		if (a!=null){
			response.sendRedirect("MyHome.jsp");
		}
	%>
	<form action="CheckLoginServlet" method="post">
    <div class="modal">
        <div class="modal-container js-conai">
            <div class="modal-close js-close">
                <i class="ti-close">

                </i>

            </div>
            <header class="modal-header">
                <i class="ti-user">
                   Sign In
                </i>
            </header>
        
            <div class="modal-body">
                <label for="1" class="modal-label">
                    <i class="ti-zip"></i>
                   UserName
                </label>
                <input id="1" type="text" class="modal-input" name="id"  >

                <label for="2" class="modal-label">
                    <i class="ti-lock"></i>
                   PassWord
                </label>
                <input id="2" type="password" class="modal-input" name="pw">
                <input type="submit" id="pay" value="Join">
            
            </div>
           
        </div>
    </div>
      </form>
      <form action="CheckSignUpServlet" method="post">
    <div class="modal1">
        <div class="modal1-container js-conai1">
            <div class="modal1-close js-close1">
                <i class="ti-close">

                </i>

            </div>
            <header class="modal1-header">
                <i class="ti-user">
                   Sign Up
                </i>
            </header>
        
            <div class="modal1-body">
                <label for="1" class="modal1-label">
                    <i class="ti-zip"></i>
                   UserName
                </label>
                <input id="1" type="text" class="modal1-input" name="id"  >

                <label for="2" class="modal1-label">
                    <i class="ti-lock"></i>
                   PassWord
                </label>
                <input id="2" type="password" class="modal1-input" name="pw">
                <input type="submit" id="pay1" value="Summit">
            
            </div>
           
        </div>
    </div>
      </form>
    <script type="text/javascript">
       const modacontainer = document.querySelector('.js-conai')
       const close1 =document.querySelector('.js-close')
       const buyBtns= document.querySelectorAll('.js-button-buy');
     const modal = document.querySelector('.modal')
      function showbuy()
      {
         modal.classList.add('open')
            
      }
      function showbuy1()
      {
         
         modal.classList.remove('open')
            
      }
     
      modal.addEventListener('click',showbuy1)
       close1.addEventListener('click',showbuy1)
       for(const buyBtn of buyBtns)
       {
           buyBtn.addEventListener('click',showbuy);
       }
     modacontainer.addEventListener('click',function(event)
      {
        event.stopPropagation()
     })
   </script>
   <script type="text/javascript">
       const modacontainera = document.querySelector('.js-conai1')
       const close1a =document.querySelector('.js-close1')
       const buyBtnsa= document.querySelectorAll('.js-button-buy1');
     const modala = document.querySelector('.modal1')
      function showbuya()
      {
         modala.classList.add('open1')
            
      }
      function showbuy1a()
      {
         
         modala.classList.remove('open1')
            
      }
     
      modala.addEventListener('click',showbuy1a)
       close1a.addEventListener('click',showbuy1a)
       for(const buyBtn of buyBtnsa)
       {
           buyBtn.addEventListener('click',showbuya);
       }
     modacontainera.addEventListener('click',function(event)
      {
        event.stopPropagation()
     })
   </script>
   
  <%
  try
  {
	  String atrString = (String)request.getSession().getAttribute("up");
  
	if (atrString.equals("OK"))
	{
%>
  <script>
      window.alert("Sign Up Success !");
     
  </script>
  <%
  request.getSession().setAttribute("up", null);
  %>
  <%}
	if(atrString.equals("NOTOK"))
  {
	%>
	<script>
      window.alert("UserName already exists !");
      
  </script>
   <%
  request.getSession().setAttribute("up", null);
  %>
  <%} 
  }catch(Exception e)
  {
  }%>
  
    
</body>
</html>