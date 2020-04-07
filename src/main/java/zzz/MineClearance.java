package zzz;
import java.util.Random;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MineClearance extends JFrame {
    private JPanel contentPane;
    private Boolean arr[][];

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MineClearance frame = new MineClearance();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MineClearance() {

        Random random = new Random();
        arr = new Boolean[5][5];
        int x, y;
        for (x = 0; x < 5; x++) {
            for (y = 0; y < 5; y++) {
                arr[x][y] = random.nextBoolean();
               // System.out.print(arr[x][y] ? "√" : "×");
               // System.out.print(' ');

                System.out.print(arr[x][y]);
                System.out.print('\0');
            }
            //System.out.println("");
            System.out.print('\n');

        }

        setTitle("\u626B\u96F7\u5C0F\u6E38\u620F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 266, 290);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabe_00 = new JLabel("");
        lblNewLabe_00.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // System.out.println(arr[0][0]);
                if (arr[0][0] == true) {
                    lblNewLabe_00.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 1; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabe_00.setText(C);
                }

            }
        });
        lblNewLabe_00.setBounds(0, 0, 50, 50);
        lblNewLabe_00.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabe_00);

        JLabel lblNewLabel_01 = new JLabel("");
        lblNewLabel_01.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[0][1] == true) {
                    lblNewLabel_01.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 1; a++) {
                        for (int b = 0; b <= 2; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_01.setText(C);
                }
            }
        });
        lblNewLabel_01.setBounds(50, 0, 50, 50);
        lblNewLabel_01.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_01);

        JLabel lblNewLabel_02 = new JLabel("");
        lblNewLabel_02.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[0][2] == true) {
                    lblNewLabel_02.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 1; a++) {
                        for (int b = 1; b <= 3; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_02.setText(C);
                }
            }
        });
        lblNewLabel_02.setBounds(100, 0, 50, 50);
        lblNewLabel_02.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_02);

        JLabel lblNewLabel_03 = new JLabel("");
        lblNewLabel_03.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[0][3] == true) {
                    lblNewLabel_03.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 1; a++) {
                        for (int b = 2; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_03.setText(C);
                }
            }
        });
        lblNewLabel_03.setBounds(150, 0, 50, 50);
        lblNewLabel_03.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_03);

        JLabel lblNewLabel_04 = new JLabel("");
        lblNewLabel_04.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[0][4] == true) {
                    lblNewLabel_04.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 1; a++) {
                        for (int b = 3; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_04.setText(C);
                }
            }
        });
        lblNewLabel_04.setBounds(200, 0, 50, 50);
        lblNewLabel_04.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_04);

        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[1][0] == true) {
                    lblNewLabel_10.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 2; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_10.setText(C);
                }
            }
        });
        lblNewLabel_10.setBounds(0, 50, 50, 50);
        lblNewLabel_10.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[1][1] == true) {
                    lblNewLabel_11.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 2; a++) {
                        for (int b = 0; b <= 2; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_11.setText(C);
                }
            }
        });
        lblNewLabel_11.setBounds(50, 50, 50, 50);
        lblNewLabel_11.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("");
        lblNewLabel_12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[1][2] == true) {
                    lblNewLabel_12.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 2; a++) {
                        for (int b = 1; b <= 3; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_12.setText(C);
                }
            }
        });
        lblNewLabel_12.setBounds(100, 50, 50, 50);
        lblNewLabel_12.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[1][3] == true) {
                    lblNewLabel_13.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 2; a++) {
                        for (int b = 2; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_13.setText(C);
                }
            }
        });
        lblNewLabel_13.setBounds(150, 50, 50, 50);
        lblNewLabel_13.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("");
        lblNewLabel_14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[1][4] == true) {
                    lblNewLabel_14.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 0; a <= 2; a++) {
                        for (int b = 3; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_14.setText(C);
                }
            }
        });
        lblNewLabel_14.setBounds(200, 50, 50, 50);
        lblNewLabel_14.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_14);

        JLabel lblNewLabel_20 = new JLabel("");
        lblNewLabel_20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[2][0] == true) {
                    lblNewLabel_20.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 1; a <= 3; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_20.setText(C);
                }
            }
        });
        lblNewLabel_20.setBounds(0, 100, 50, 50);
        lblNewLabel_20.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_20);

        JLabel lblNewLabel_21 = new JLabel("");
        lblNewLabel_21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[2][1] == true) {
                    lblNewLabel_21.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 1; a <= 3; a++) {
                        for (int b = 0; b <= 2; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_21.setText(C);
                }
            }
        });
        lblNewLabel_21.setBounds(50, 100, 50, 50);
        lblNewLabel_21.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_21);

        JLabel lblNewLabel_22 = new JLabel("");
        lblNewLabel_22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[2][2] == true) {
                    lblNewLabel_22.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 1; a <= 3; a++) {
                        for (int b = 1; b <= 3; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_22.setText(C);
                }
            }
        });
        lblNewLabel_22.setBounds(100, 100, 50, 50);
        lblNewLabel_22.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_22);

        JLabel lblNewLabel_23 = new JLabel("");
        lblNewLabel_23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[2][3] == true) {
                    lblNewLabel_23.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 1; a <= 3; a++) {
                        for (int b = 2; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_23.setText(C);
                }
            }
        });
        lblNewLabel_23.setBounds(150, 100, 50, 50);
        lblNewLabel_23.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_23);

        JLabel lblNewLabel_24 = new JLabel("");
        lblNewLabel_24.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[2][4] == true) {
                    lblNewLabel_24.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 1; a <= 3; a++) {
                        for (int b = 3; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_24.setText(C);
                }
            }
        });
        lblNewLabel_24.setBounds(200, 100, 50, 50);
        lblNewLabel_24.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_24);

        JLabel lblNewLabel_30 = new JLabel("");
        lblNewLabel_30.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[3][0] == true) {
                    lblNewLabel_30.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 2; a <= 4; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_30.setText(C);
                }
            }
        });
        lblNewLabel_30.setBounds(0, 150, 50, 50);
        lblNewLabel_30.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_30);

        JLabel lblNewLabel_31 = new JLabel("");
        lblNewLabel_31.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[3][1] == true) {
                    lblNewLabel_31.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 2; a <= 4; a++) {
                        for (int b = 0; b <= 2; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_31.setText(C);
                }
            }
        });
        lblNewLabel_31.setBounds(50, 150, 50, 50);
        lblNewLabel_31.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_31);

        JLabel lblNewLabel_32 = new JLabel("");
        lblNewLabel_32.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[3][2] == true) {
                    lblNewLabel_32.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 2; a <= 4; a++) {
                        for (int b = 1; b <= 3; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_32.setText(C);
                }
            }
        });
        lblNewLabel_32.setBounds(100, 150, 50, 50);
        lblNewLabel_32.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_32);

        JLabel lblNewLabel_33 = new JLabel("");
        lblNewLabel_33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[3][3] == true) {
                    lblNewLabel_33.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 2; a <= 4; a++) {
                        for (int b = 2; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_33.setText(C);
                }
            }
        });
        lblNewLabel_33.setBounds(150, 150, 50, 50);
        lblNewLabel_33.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_33);

        JLabel lblNewLabel_34 = new JLabel("");
        lblNewLabel_34.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[3][4] == true) {
                    lblNewLabel_34.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 2; a <= 4; a++) {
                        for (int b = 3; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_34.setText(C);
                }
            }
        });
        lblNewLabel_34.setBounds(200, 150, 50, 50);
        lblNewLabel_34.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_34);

        JLabel lblNewLabel_40 = new JLabel("");
        lblNewLabel_40.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[4][0] == true) {
                    lblNewLabel_40.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 3; a <= 4; a++) {
                        for (int b = 0; b <= 1; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_40.setText(C);
                }
            }
        });
        lblNewLabel_40.setBounds(0, 200, 50, 50);
        lblNewLabel_40.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_40);

        JLabel lblNewLabel_41 = new JLabel("");
        lblNewLabel_41.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[4][1] == true) {
                    lblNewLabel_41.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 3; a <= 4; a++) {
                        for (int b = 0; b <= 2; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_41.setText(C);
                }
            }
        });
        lblNewLabel_41.setBounds(50, 200, 50, 50);
        lblNewLabel_41.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_41);

        JLabel lblNewLabel_42 = new JLabel("");
        lblNewLabel_42.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[4][2] == true) {
                    lblNewLabel_42.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 3; a <= 4; a++) {
                        for (int b = 1; b <= 3; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_42.setText(C);
                }
            }
        });
        lblNewLabel_42.setBounds(100, 200, 50, 50);
        lblNewLabel_42.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_42);

        JLabel lblNewLabel_43 = new JLabel("");
        lblNewLabel_43.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[4][3] == true) {
                    lblNewLabel_43.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 3; a <= 4; a++) {
                        for (int b = 2; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_43.setText(C);
                }
            }
        });
        lblNewLabel_43.setBounds(150, 200, 50, 50);
        lblNewLabel_43.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_43);

        JLabel lblNewLabel_44 = new JLabel("");
        lblNewLabel_44.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(arr[0][0]);
                if (arr[4][4] == true) {
                    lblNewLabel_44.setText("炸了");
                    JOptionPane.showMessageDialog(null, "GAME OVER!", "提示框", JOptionPane.WARNING_MESSAGE);
                }

                else {
                    int c = 0;
                    for (int a = 3; a <= 4; a++) {
                        for (int b = 3; b <= 4; b++) {
                            if (arr[a][b] == true)
                                c = c + 1;
                        }

                    }
                    String C = String.valueOf(c);
                    lblNewLabel_44.setText(C);
                }
            }
        });
        lblNewLabel_44.setBounds(200, 200, 50, 50);
        lblNewLabel_44.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(lblNewLabel_44);

    }
}
