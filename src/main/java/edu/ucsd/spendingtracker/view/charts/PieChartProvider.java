package edu.ucsd.spendingtracker.view.charts;


import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import java.util.Map;

import edu.ucsd.spendingtracker.model.Category;

public class PieChartProvider implements IChartProvider {
    @Override
    public Node createChart(Map<Category, Double> data) {
        PieChart chart = new PieChart();

        data.forEach((cat, sum) -> {
            PieChart.Data slice = new PieChart.Data(cat.name(), sum);
            chart.getData().add(slice);
        });

        for(PieChart.Data slice : chart.getData()){
            Node n = slice.getNode();
             String color = Category.valueOf(slice.getName()).color;
             n.setStyle(n.getStyle() + "; -fx-pie-color: " + color + ";");
            }

        chart.setLegendVisible(false);
        return chart;
    }


    @Override
    public String getDisplayName(){
        return "Pie Chart";
    }

}