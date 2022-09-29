package oose.controller;

import oose.persistence.dto.SalesDTO;
import oose.service.SalesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SalesController implements Controller
{
    private final SalesService salesService = new SalesService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException {
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("\n-------------SalesController---------------\n");
        System.out.println("---------------url-------------\n" + url);

        try
        {
            // /mngSales/selectPeriod => url
            // /salesMng/period_sales => 파일경로
            if (url.equals("/mngSales/selectPeriod")) {
                if (request.getMethod().equals("GET")) {
                    modelAndView.setViewName("/salesMng/period_sales");
                } else if (request.getMethod().equals("POST")) {
                    System.out.println("post 들어옴");
                    if (request.getParameter("action").equals("조회")) {
                        try {
                            SalesDTO salesDTO = new SalesDTO();

                            java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("start_date"));
                            salesDTO.setStartDate(startDate);
                            java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("end_date"));
                            salesDTO.setEndDate(endDate);

                            ArrayList<SalesDTO> list = salesService.byPeriodService(startDate, endDate);
                            modelAndView.setViewName("/salesMng/period_sales");
                            modelAndView.getModel().put("list", list);
                            String pageUrl = "/mng/mngSales/selectPeriod";
                            alert(request, response, pageUrl, "조회 완료");
                        } catch (Exception e) {
                            String pageUrl = "/mng/mngSales/selectPeriod";
                            alert(request, response, pageUrl, "다시 입력바람");
                        }
                    } else if (request.getParameter("action").equals("돌아가기")) {
                        modelAndView.setViewName("../../index");
                    }
                }
                return modelAndView;
            }

            // /mngSales/selectLec => url
            // /salesMng/lecture_sales => 파일경로
            else if (url.equals("/mngSales/selectLec")) {
                if (request.getMethod().equals("GET")) {
                    modelAndView.setViewName("/salesMng/lecture_sales");
                } else if (request.getMethod().equals("POST")) {
                    System.out.println("post 들어옴");
                    if (request.getParameter("action").equals("조회")) {
                        try {
                            SalesDTO salesDTO = new SalesDTO();

                            int classCode = Integer.parseInt(request.getParameter("classCode"));
                            salesDTO.setClassCode(classCode);
                            ArrayList<SalesDTO> list2 = salesService.byLecService(classCode);

                            modelAndView.setViewName("/salesMng/lecture_sales");
                            modelAndView.getModel().put("list2", list2);
                            String pageUrl = "/mng/mngSales/selectLec";
                            alert(request, response, pageUrl, "조회 완료");
                        } catch (Exception e) {
                            String pageUrl = "/mng/mngSales/selectLec";
                            alert(request, response, pageUrl, "다시 입력바람");
                        }
                    } else if (request.getParameter("action").equals("돌아가기")) {
                        modelAndView.setViewName("../../index");
                    }
                }
                return modelAndView;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void alert(HttpServletRequest request, HttpServletResponse response, String url, String msg) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script>alert('" + msg + "'); location.href='" + url + "';</script>");
        writer.close();
    }
}