<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
          <tiles:insertAttribute name="header"/>
      </head>
      <body>
          <header id="header">
              <tiles:insertAttribute name="nav"/>
          </header>
          <aside id="left-panel">
              <tiles:insertAttribute name="left"/>
          </aside>

          <!-- MAIN PANEL -->
        <div id="main" role="main">
            <div id="ribbon"></div>

            <tiles:insertAttribute name="content"/>
        </div>

          <tiles:insertAttribute name="footer"/>
      </body>
</html>