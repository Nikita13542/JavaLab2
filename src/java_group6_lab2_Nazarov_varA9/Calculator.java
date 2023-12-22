package java_group6_lab2_Nazarov_varA9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class Calculator {

    private JFrame mainFrame = new JFrame();
    private JLabel resultLabel = new JLabel();
    private JLabel memoryTextLabelData = new JLabel("0");
    private int activeFormula = 1;

    Calculator() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() * 480 / 1920;
        int height = gd.getDisplayMode().getHeight() * 400 / 1080;

        mainFrame.setSize(width, height);

        JButton buttonMemoryPlus = new JButton("M+");
        buttonMemoryPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double newValue = Double.parseDouble(resultLabel.getText()) + Double.parseDouble(memoryTextLabelData.getText());
                memoryTextLabelData.setText(newValue.toString());
            }
        });

        JButton buttonMemoryClear = new JButton("MC");
        buttonMemoryClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoryTextLabelData.setText("0");
            }
        });

        JRadioButton rbFormula1 = new JRadioButton("Уравнение 1");
        JRadioButton rbFormula2 = new JRadioButton("Уравнение 2");

        rbFormula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.this.activeFormula = 1;
            }
        });

        rbFormula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.this.activeFormula = 2;
            }
        });

        rbFormula1.setSelected(true);

        ButtonGroup formulaButtonGroup = new ButtonGroup();
        formulaButtonGroup.add(rbFormula1);
        formulaButtonGroup.add(rbFormula2);

        JTextField textVariableX = new JTextField("0", 6);
        JTextField textVariableY = new JTextField("0", 6);
        JTextField textVariableZ = new JTextField("0", 6);

        JButton buttonCalculate = new JButton("Calculate");

        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double result = null;
                double x = Double.parseDouble(textVariableX.getText());
                double y = Double.parseDouble(textVariableY.getText());
                double z = Double.parseDouble(textVariableZ.getText());
                switch (Calculator.this.activeFormula) {
                    case (1) -> result = calculateFirstFormula(x, y, z);
                    case (2) -> result = calculateSecondFormula(x, y, z);
                }

                Calculator.this.resultLabel.setText(result.toString());
            }
        });

        Box hboxFormulaChoice = Box.createHorizontalBox();
        hboxFormulaChoice.add(Box.createHorizontalGlue());
        hboxFormulaChoice.add(rbFormula1);
        hboxFormulaChoice.add(rbFormula2);
        hboxFormulaChoice.add(Box.createHorizontalGlue());

        Box hboxMemory = Box.createHorizontalBox();
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.add(buttonMemoryPlus);
        hboxMemory.add(buttonMemoryClear);
        hboxMemory.add(Box.createHorizontalStrut(20));
        hboxMemory.add(memoryTextLabelData);
        hboxMemory.add(Box.createHorizontalGlue());

        Box hboxFunc = Box.createHorizontalBox();
        hboxFunc.add(Box.createHorizontalStrut(10));
        hboxFunc.add(new JLabel("x:"));
        hboxFunc.add(Box.createHorizontalStrut(3));
        hboxFunc.add(textVariableX);

        hboxFunc.add(Box.createHorizontalGlue());
        hboxFunc.add(new JLabel("y:"));
        hboxFunc.add(Box.createHorizontalStrut(3));
        hboxFunc.add(textVariableY);

        hboxFunc.add(Box.createHorizontalGlue());
        hboxFunc.add(new JLabel("z:"));
        hboxFunc.add(Box.createHorizontalStrut(3));
        hboxFunc.add(textVariableZ);

        textVariableX.setColumns(10);
        textVariableX.setMaximumSize(new Dimension(100, textVariableX.getPreferredSize().height));

        textVariableY.setColumns(10);
        textVariableY.setMaximumSize(new Dimension(100, textVariableY.getPreferredSize().height));

        textVariableZ.setColumns(10);
        textVariableZ.setMaximumSize(new Dimension(100, textVariableZ.getPreferredSize().height));

        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(new JLabel("Result:"));
        hboxResult.add(Box.createHorizontalStrut(5));
        hboxResult.add(resultLabel);

        Box hboxVariables = Box.createVerticalBox();
        hboxVariables.add(hboxFunc);
        hboxVariables.add(Box.createVerticalStrut(10));
        hboxVariables.add(hboxResult);
        hboxVariables.add(Box.createHorizontalGlue());

        Box hboxCalculate = Box.createHorizontalBox();
        hboxCalculate.add(buttonCalculate);

        Box contentBox = Box.createVerticalBox();
        contentBox.add(hboxFormulaChoice);
        contentBox.add(hboxMemory);
        contentBox.add(hboxVariables);
        contentBox.add(hboxCalculate);
        contentBox.add(Box.createVerticalGlue());

        mainFrame.getContentPane().add(contentBox);
    }

    private Double calculateFirstFormula(Double x, Double y, Double z) {
        return (sin(sin(y + exp(cos(y))) + pow(z, 2)) * (pow(sin(PI * (pow(y, 2)) + log(pow(x, 2))), 1 / 4)));
    }

    private Double calculateSecondFormula(Double x, Double y, Double z) {
        return ((atan(pow(z, 1 / x))) / (pow(y, 2) + z * (sin(log(x)))));
    }

    public void setVisible(boolean state) {
        mainFrame.setVisible(state);
    }
}