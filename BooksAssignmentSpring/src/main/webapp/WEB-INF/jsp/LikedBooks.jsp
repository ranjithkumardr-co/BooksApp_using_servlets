<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.hcl.Dao.*"%>
    <%@page import="com.hcl.beans.*"%>
    <%@page import="java.util.*"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">

    

    <!-- Bootstrap core CSS -->
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }



body {
background:rgba(0,0,0,.03);;

}

.rounded-3 {
    border-radius: .7rem!important;
}




      
  
      
      @media only screen and (max-width: 1106px) and (min-width: 700px)
      {
      
              .row-cols-md-5>* {
    flex: 0 0 auto;
    width: 50%;
}
      }
      
            @media only screen and (max-width: 700px) and (min-width: 200px)
      {
      
              .row-cols-md-5>* {
    flex: 0 0 auto;
    width: 100%;
}
      }
      
            
      @media only screen and (max-width: 1430px) and (min-width: 1106px)
      {
      
              .row-cols-md-5>* {
    flex: 0 0 auto;
    width: 33.3%;
}
      }
      
      
            @media only screen and (max-width: 1700px) and (min-width: 1430px)
      {
      
              .row-cols-md-5>* {
    flex: 0 0 auto;
    width: 25%;
}
      }

      
      .row {
    --bs-gutter-x: 1.5rem;
    --bs-gutter-y: 0;
    display: flex;
    flex-wrap:wrap;
    /* margin-top: calc(-1 * var(--bs-gutter-y)); */
    /* margin-right: calc(-.5 * var(--bs-gutter-x)); */
    /* margin-left: calc(-.5 * var(--bs-gutter-x)); */
    margin-top: 2em;
    margin-right: 7em;
    margin-left: 7em;
    }
    
    h1.pricing-card-title
    {
   width:86.1%;
    padding: 0.7em;
    margin-bottom: 0;
    background-color: rgba(0,0,0,.03);
    border: 1px solid rgba(0,0,0,.125);
    text-transform: capitalize;
    text-align: left;
    font-family:inherit;
    border-bottom-left-radius: 1em;
    border-bottom-right-radius: 1em;
    margin-left: 3em;
    margin-right:2em;
    
    
    
    }
    
    body{

         
    
    }
    

        img {
            
            width: 250px !important;
            height: 330px !important;
            object-fit:hidden;
        }
    
        
        .col:hover
        {
        
         transform: scale(1.05);
            box-shadow:  rgba(26, 23, 23, 0.12),  rgba(0, 0, 0, .06);
            
         
            
        }
        
          .col {
          
           
            transition: 0.2s transform cubic-bezier(.155, 1.105, .295, 1.12), .3s box-shadow, .3s -webkit-transform cubic-bezier(.155, 1.105, .295, 1.12);
            /* padding: 14px 80px 18px 36px; */
            cursor: pointer;
            
            
        }
        
          .row {
            margin-right: 8rem;
            margin-left: 5rem
        }
        
        svg{
        
        margin-right: 2em;
        }
        
        .alert {
	position: relative;
	padding: 0.5%;
	margin-bottom: 1rem;
	border: 1 px solid transparent;
	border-radius: 0.25 rem;
	margin: auto;
	height: min-content;
	width: 30%;
}
.btn-close{
height:0em !important;
}
    </style>

    
    <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
  </head>
  <body>
    <%ArrayList<Books> list2=new ArrayList<Books>();
list2=(ArrayList<Books>)request.getAttribute("BooksLikedList");%>
    


<main>
  





  

  

   <header class=" p-3 bg-dark text-white">
   <%if((String)request.getAttribute("message")!=null) { %>
			<div class="alert alert-<%=(String)request.getAttribute("alerttype") %> alert-dismissible fade show">
				<button type="button" onclick="close();" class="btn-close" data-bs-dismiss="alert"></button>
				<strong></strong>
				<%=(String)request.getAttribute("message") %>
				<%} %>
			</div>
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="http://localhost:8080/BooksAssignmentSpring/home" class="d-flex align-items-center mb-2 mb-lg-0 text-black text-decoration-none">
        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="white" class="bi bi-book mx-10" viewBox="0 0 16 16" >
  <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
</svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="./home" class="nav-link px-2 text-white">Home</a></li>
          <li><a href="./DisplayBooksLiked" class="nav-link px-2 text-secondary">Books Liked</a></li>
          <li><a href="./DisplayReadLater" class="nav-link px-2 text-white">Read Later</a></li>
         
        </ul>

      

        <div class="text-end">
          <button type="button" class="btn btn-outline-light me-2" onclick="location.href='./login'">Login</button>
          <button type="button" class="btn btn-danger" onclick="location.href='./Register'">Register</button>
          <button type="button" class="btn btn-danger" onclick="location.href='./logout'">Logout</button>
        </div>
      </div>
    </div>
  </header>

<h1 class="pricing-card-title">Welcome <small class="text-muted fw-light"><%=(String)session.getAttribute("name")%></small></h1>
  <div class="row row-cols-1 row-cols-md-5 mb-4 text-center">
  
  <%if(list2==null || list2.isEmpty()){ %>
    
    <div class="col">
      <div class="card mb-4 rounded-3 shadow-sm float-end">
        <div class="card-header py-3">
          <h4 class="my-0 fw-normal"></h4>
        </div>
        <div class="card-body">
          <img src="https://vip28.hachette.co.uk/wp-content/uploads/2018/07/missingbook.png" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">No Books Liked</h5>
            
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Please Like</li>
            <li class="list-group-item">Books To see</li>

            
           
          </ul>
          <div class="card-body">
            
           
          </div>
        </div>
      </div>
    </div>
    
    <%} %>
    
    
    <%for(Books c : list2) { %>
    <div class="col">
      <div class="card mb-4 rounded-3 shadow-sm float-end">
        <div class="card-header py-3">
          <h4 class="my-0 fw-normal"><%=c.getBookid()%></h4>
        </div>
        <div class="card-body">
          <img src="<%=c.getBookurl()%>" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title"><%=c.getBookname()%></h5>
            
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Category : <%=c.getCategory()%></li>
            <li class="list-group-item">Author : <%=c.getAuthorname()%></li>

            
           
          </ul>
          <div class="card-body">
            
            
            <a href="RemoveLikedBook/<%= c.getBookid() %>" class="btn btn-danger w-70">Remove</a>
          </div>
        </div>
      </div>
    </div>
    <%} %>
    
    
    
    
  </div>
  
</main>


    <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      
  </body>
</html>
