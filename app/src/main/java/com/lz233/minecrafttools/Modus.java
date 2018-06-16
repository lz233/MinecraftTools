package com.lz233.minecrafttools;

import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lz233 on 18-5-11.
 */

public class Modus {
    public String loadFromSDFile(String fname) {
        fname="/"+fname;
        String result=null;
        try {
            File f=new File(Environment.getExternalStorageDirectory().getPath()+fname);
            int length=(int)f.length();
            byte[] buff=new byte[length];
            FileInputStream fin=new FileInputStream(f);
            fin.read(buff);
            fin.close();
            result=new String(buff,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            //Toast.makeText(MainActivity.this,"没有找到指定文件",Toast.LENGTH_SHORT).show();
        }
        return result;
    }
    public long getkeytime (){
        String key = loadFromSDFile("lz233/key.txt");
        char[] keychar = new StringBuffer().append(key).reverse().toString().toCharArray();
        //long keytime = keytimelong - loctime;
        long keytime = 0;
        if (keychar.length!=13){
            keytime = -1;
        }else {
            int[] keytimeint1 = new int[13];
            for (int i = 0; i < keychar.length; i++) {
                StringBuffer item = new StringBuffer();
                String x = item.append(keychar[i]).toString();
                if (x.equals("F")) {
                    keytimeint1[i] = 0;
                }
                if (x.equals("f")) {
                    keytimeint1[i] = 0;
                }
                if (x.equals("W")) {
                    keytimeint1[i] = 1;
                }
                if (x.equals("w")) {
                    keytimeint1[i] = 1;
                }
                if (x.equals("Q")) {
                    keytimeint1[i] = 2;
                }
                if (x.equals("q")) {
                    keytimeint1[i] = 2;
                }
                if (x.equals("K")) {
                    keytimeint1[i] = 3;
                }
                if (x.equals("k")) {
                    keytimeint1[i] = 3;
                }
                if (x.equals("M")) {
                    keytimeint1[i] = 4;
                }
                if (x.equals("m")) {
                    keytimeint1[i] = 4;
                }
                if (x.equals("V")) {
                    keytimeint1[i] = 5;
                }
                if (x.equals("v")) {
                    keytimeint1[i] = 5;
                }
                if (x.equals("G")) {
                    keytimeint1[i] = 6;
                }
                if (x.equals("g")) {
                    keytimeint1[i] = 6;
                }
                if (x.equals("S")) {
                    keytimeint1[i] = 7;
                }
                if (x.equals("s")) {
                    keytimeint1[i] = 7;
                }
                if (x.equals("A")) {
                    keytimeint1[i] = 8;
                }
                if (x.equals("a")) {
                    keytimeint1[i] = 8;
                }
                if (x.equals("U")) {
                    keytimeint1[i] = 9;
                }
                if (x.equals("u")) {
                    keytimeint1[i] = 9;
                }
            }
            int[] keytimeint2 = new int[13];
            for (int i = 0; i < keychar.length; i++) {
                StringBuffer item = new StringBuffer();
                String x = item.append(keychar[i]).toString();
                if (x.equals("F")) {
                    if (new StringBuffer().append(keytimeint1[10]).toString().equals("2")) {
                        keytimeint2[i] = 0;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("f")) {
                    if (new StringBuffer().append(keytimeint1[10]).toString().equals("2")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 0;
                    }
                }

                if (x.equals("W")) {
                    if (new StringBuffer().append(keytimeint1[0]).toString().equals("8")) {
                        keytimeint2[i] = 1;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("w")) {
                    if (new StringBuffer().append(keytimeint1[0]).toString().equals("8")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 1;
                    }
                }

                if (x.equals("q")) {
                    if (new StringBuffer().append(keytimeint1[12]).toString().equals("5")) {
                        keytimeint2[i] = 2;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("Q")) {
                    if (new StringBuffer().append(keytimeint1[12]).toString().equals("5")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 2;
                    }
                }

                if (x.equals("k")) {
                    if (new StringBuffer().append(keytimeint1[8]).toString().equals("7")) {
                        keytimeint2[i] = 3;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("K")) {
                    if (new StringBuffer().append(keytimeint1[8]).toString().equals("7")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 3;
                    }
                }

                if (x.equals("M")) {
                    if (new StringBuffer().append(keytimeint1[4]).toString().equals("3")) {
                        keytimeint2[i] = 4;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("m")) {
                    if (new StringBuffer().append(keytimeint1[4]).toString().equals("3")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 4;
                    }
                }

                if (x.equals("V")) {
                    if (new StringBuffer().append(keytimeint1[2]).toString().equals("4")) {
                        keytimeint2[i] = 5;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("v")) {
                    if (new StringBuffer().append(keytimeint1[2]).toString().equals("4")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 5;
                    }
                }

                if (x.equals("g")) {
                    if (new StringBuffer().append(keytimeint1[9]).toString().equals("6")) {
                        keytimeint2[i] = 6;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("G")) {
                    if (new StringBuffer().append(keytimeint1[9]).toString().equals("6")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 6;
                    }
                }

                if (x.equals("S")) {
                    if (new StringBuffer().append(keytimeint1[5]).toString().equals("9")) {
                        keytimeint2[i] = 7;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("s")) {
                    if (new StringBuffer().append(keytimeint1[5]).toString().equals("9")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 7;
                    }
                }

                if (x.equals("A")) {
                    if (new StringBuffer().append(keytimeint1[3]).toString().equals("1")) {
                        keytimeint2[i] = 8;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("a")) {
                    if (new StringBuffer().append(keytimeint1[3]).toString().equals("1")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 8;
                    }
                }

                if (x.equals("u")) {
                    if (new StringBuffer().append(keytimeint1[7]).toString().equals("5")) {
                        keytimeint2[i] = 9;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("U")) {
                    if (new StringBuffer().append(keytimeint1[7]).toString().equals("5")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 9;
                    }
                }
            }
            if (keytime != -1) {
                long keytimelong = new Double(keytimeint2[0] * 1000000000 + keytimeint2[1] * 100000000 + keytimeint2[2] * 10000000 + keytimeint2[3] * 1000000 + keytimeint2[4] * 100000 + keytimeint2[5] * 10000 + keytimeint2[6] * 1000 + keytimeint2[7] * 100 + keytimeint2[8] * 10 + keytimeint2[9]  + keytimeint2[10] * 0.1 + keytimeint2[11] * 0.01 + keytimeint2[12]*0.001).longValue();
                long loctime = System.currentTimeMillis()/1000;
                keytime =keytimelong - loctime;
            }
        }
        return keytime;
    }
    public long getkeytime (String key){
        char[] keychar = new StringBuffer().append(key).reverse().toString().toCharArray();
        //long keytime = keytimelong - loctime;
        long keytime = 0;
        if (keychar.length!=13){
            keytime = -1;
        }else {
            int[] keytimeint1 = new int[13];
            for (int i = 0; i < keychar.length; i++) {
                StringBuffer item = new StringBuffer();
                String x = item.append(keychar[i]).toString();
                if (x.equals("F")) {
                    keytimeint1[i] = 0;
                }
                if (x.equals("f")) {
                    keytimeint1[i] = 0;
                }
                if (x.equals("W")) {
                    keytimeint1[i] = 1;
                }
                if (x.equals("w")) {
                    keytimeint1[i] = 1;
                }
                if (x.equals("Q")) {
                    keytimeint1[i] = 2;
                }
                if (x.equals("q")) {
                    keytimeint1[i] = 2;
                }
                if (x.equals("K")) {
                    keytimeint1[i] = 3;
                }
                if (x.equals("k")) {
                    keytimeint1[i] = 3;
                }
                if (x.equals("M")) {
                    keytimeint1[i] = 4;
                }
                if (x.equals("m")) {
                    keytimeint1[i] = 4;
                }
                if (x.equals("V")) {
                    keytimeint1[i] = 5;
                }
                if (x.equals("v")) {
                    keytimeint1[i] = 5;
                }
                if (x.equals("G")) {
                    keytimeint1[i] = 6;
                }
                if (x.equals("g")) {
                    keytimeint1[i] = 6;
                }
                if (x.equals("S")) {
                    keytimeint1[i] = 7;
                }
                if (x.equals("s")) {
                    keytimeint1[i] = 7;
                }
                if (x.equals("A")) {
                    keytimeint1[i] = 8;
                }
                if (x.equals("a")) {
                    keytimeint1[i] = 8;
                }
                if (x.equals("U")) {
                    keytimeint1[i] = 9;
                }
                if (x.equals("u")) {
                    keytimeint1[i] = 9;
                }
            }
            int[] keytimeint2 = new int[13];
            for (int i = 0; i < keychar.length; i++) {
                StringBuffer item = new StringBuffer();
                String x = item.append(keychar[i]).toString();
                if (x.equals("F")) {
                    if (new StringBuffer().append(keytimeint1[10]).toString().equals("2")) {
                        keytimeint2[i] = 0;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("f")) {
                    if (new StringBuffer().append(keytimeint1[10]).toString().equals("2")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 0;
                    }
                }

                if (x.equals("W")) {
                    if (new StringBuffer().append(keytimeint1[0]).toString().equals("8")) {
                        keytimeint2[i] = 1;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("w")) {
                    if (new StringBuffer().append(keytimeint1[0]).toString().equals("8")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 1;
                    }
                }

                if (x.equals("q")) {
                    if (new StringBuffer().append(keytimeint1[12]).toString().equals("5")) {
                        keytimeint2[i] = 2;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("Q")) {
                    if (new StringBuffer().append(keytimeint1[12]).toString().equals("5")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 2;
                    }
                }

                if (x.equals("k")) {
                    if (new StringBuffer().append(keytimeint1[8]).toString().equals("7")) {
                        keytimeint2[i] = 3;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("K")) {
                    if (new StringBuffer().append(keytimeint1[8]).toString().equals("7")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 3;
                    }
                }

                if (x.equals("M")) {
                    if (new StringBuffer().append(keytimeint1[4]).toString().equals("3")) {
                        keytimeint2[i] = 4;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("m")) {
                    if (new StringBuffer().append(keytimeint1[4]).toString().equals("3")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 4;
                    }
                }

                if (x.equals("V")) {
                    if (new StringBuffer().append(keytimeint1[2]).toString().equals("4")) {
                        keytimeint2[i] = 5;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("v")) {
                    if (new StringBuffer().append(keytimeint1[2]).toString().equals("4")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 5;
                    }
                }

                if (x.equals("g")) {
                    if (new StringBuffer().append(keytimeint1[9]).toString().equals("6")) {
                        keytimeint2[i] = 6;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("G")) {
                    if (new StringBuffer().append(keytimeint1[9]).toString().equals("6")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 6;
                    }
                }

                if (x.equals("S")) {
                    if (new StringBuffer().append(keytimeint1[5]).toString().equals("9")) {
                        keytimeint2[i] = 7;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("s")) {
                    if (new StringBuffer().append(keytimeint1[5]).toString().equals("9")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 7;
                    }
                }

                if (x.equals("A")) {
                    if (new StringBuffer().append(keytimeint1[3]).toString().equals("1")) {
                        keytimeint2[i] = 8;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("a")) {
                    if (new StringBuffer().append(keytimeint1[3]).toString().equals("1")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 8;
                    }
                }

                if (x.equals("u")) {
                    if (new StringBuffer().append(keytimeint1[7]).toString().equals("5")) {
                        keytimeint2[i] = 9;
                    } else {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    }
                }
                if (x.equals("U")) {
                    if (new StringBuffer().append(keytimeint1[7]).toString().equals("5")) {
                        keytime = -1;
                        keytimeint2 = null;
                        break;
                    } else {
                        keytimeint2[i] = 9;
                    }
                }
            }
            if (keytime != -1) {
                long keytimelong = new Double(keytimeint2[0] * 1000000000 + keytimeint2[1] * 100000000 + keytimeint2[2] * 10000000 + keytimeint2[3] * 1000000 + keytimeint2[4] * 100000 + keytimeint2[5] * 10000 + keytimeint2[6] * 1000 + keytimeint2[7] * 100 + keytimeint2[8] * 10 + keytimeint2[9]  + keytimeint2[10] * 0.1 + keytimeint2[11] * 0.01 + keytimeint2[12]*0.001).longValue();
                long loctime = System.currentTimeMillis()/1000;
                keytime =keytimelong - loctime;
            }
        }
        return keytime;
    }
}
