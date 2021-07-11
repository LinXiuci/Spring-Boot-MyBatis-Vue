<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="./css/index.css">
</head>

<body>

    <h1 class="welcome">
        <span>欢迎你！${USERNAME.username}</span>
        <a href="${pageContext.request.contextPath}/logout">注销</a>
    </h1>
    <section id="box">
        <section id="demo" class="carousel slide" data-ride="carousel">

            <!-- 指示符 -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
                <li data-target="#demo" data-slide-to="3"></li>
            </ul>

            <!-- 轮播图片 -->
            <article class="carousel-inner">
                <div class="carousel-item active">
                    <img
                         src="https://openfile.meizu.com/group1/M00/08/AC/Cgbj0WCwurOAdJ4nAAMP7A7GApc493.png680x680.jpg">
                </div>
                <div class="carousel-item">
                    <img
                         src="https://openfile.meizu.com/group1/M00/08/AB/Cgbj0WCwuqSAJ_prAAS2X3WpnVc765.png680x680.jpg">

                </div>
                <div class="carousel-item">
                    <img
                         src="https://openfile.meizu.com/group1/M00/08/99/Cgbj0GCwuqSAUH2xAAO-sIvM4B8557.png680x680.jpg">
                </div>

                <div class="carousel-item">
                    <img
                         src="https://openfile.meizu.com/group1/M00/08/AB/Cgbj0WCwuq2APJdKAAMDgh-RYRQ026.png680x680.jpg">
                </div>

            </article>

            <!-- 左右切换按钮 -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </section>

        <aside>
            <h1 id="watch-box">
                <span class="watch-box-text1">Flyme for Watch</span>
                <span class="watch-box-text2">妙连协作生态联动</span>
            </h1>
            <div id="watch-box-2">
                <span>RMB 150/月 或 起 RMB 3599</span>
            </div>
            <div id="watch-box-3">
                <p>铝金属表壳十分轻盈，采用 100% 再生的航空级铝金属制成。</p>
                <p>Fiyme 的愉悦体验，现已延伸到Flyme for Watch 中。</p>
            </div>

            <form method="POST" action="${pageContext.request.contextPath}/success">
                <select autofocus id="watch-select">
                    <option value="">北京</option>
                    <option value="">广州</option>
                    <option value="">深圳</option>
                    <option value="">上海</option>
                </select>
                <input id="watch-add" type="submit" value="加入购物车">
            </form>
        </aside>
    </section>
</body>

</html>
