# -*- coding: utf-8 -*-

import os,shutil

UArr =[
            '&#x0627;',
            '&#xFE8E;',

            '&#x06D5;',
            '&#xFEEA;',

            '&#x0628;',
            '&#xFE91;',
            '&#xFE92;',
            '&#xFE90;',

            '&#x067E;',
            '&#xFB58;',
            '&#xFB59;',
            '&#xFB57;',

            '&#x062A;',
            '&#xFE97;',
            '&#xFE98;',
            '&#xFE96;',

            '&#x062C;',
            '&#xFE9F;',
            '&#xFEA0;',
            '&#xFE9E;',

            '&#x0686;',
            '&#xFB7C;',
            '&#xFB7D;',
            '&#xFB7B;',

            '&#x062E;',
            '&#xFEA7;',
            '&#xFEA8;',
            '&#xFEA6;',

            '&#x062F;',
            '&#xFEAA;',

            '&#x0631;',
            '&#xFEAE;',

            '&#x0632;',
            '&#xFEB0;',

            '&#x0698;',
            '&#xFB8B;',

            '&#x0633;',
            '&#xFEB3;',
            '&#xFEB4;',
            '&#xFEB2;',

            '&#x0634;',
            '&#xFEB7;',
            '&#xFEB8;',
            '&#xFEB6;',

            '&#x063A;',
            '&#xFECF;',
            '&#xFED0;',
            '&#xFECE;',

            '&#x0641;',
            '&#xFED3;',
            '&#xFED4;',
            '&#xFED2;',

            '&#x0642;',
            '&#xFED7;',
            '&#xFED8;',
            '&#xFED6;',

            '&#x0643;',
            '&#xFEDB;',
            '&#xFEDC;',
            '&#xFEDA;',

            '&#x06AF;',
            '&#xFB94;',
            '&#xFB95;',
            '&#xFB93;',

            '&#x06AD;',
            '&#xFBD5;',
            '&#xFBD6;',
            '&#xFBD4;',

            '&#x0644;',
            '&#xFEDF;',
            '&#xFEE0;',
            '&#xFEDE;',

            '&#x0645;',
            '&#xFEE3;',
            '&#xFEE4;',
            '&#xFEE2;',

            '&#x0646;',
            '&#xFEE7;',
            '&#xFEE8;',
            '&#xFEE6;',

            '&#x06BE;',
            '&#xFBAC;',
            '&#xFBAD;',
            '&#xFBAB;',

            '&#x0648;',
            '&#xFEEE;',

            '&#x06C7;',
            '&#xFBD8;',

            '&#x06C6;',
            '&#xFBDA;',

            '&#x06C8;',
            '&#xFBDC;',

            '&#x06CB;',
            '&#xFBDF;',

            '&#x06D0;',
            '&#xFBE6;',
            '&#xFBE7;',
            '&#xFBE5;',

            '&#x0649;',
            '&#xFBE8;',
            '&#xFBE9;',
            '&#xFEF0;',

            '&#x064A;',
            '&#xFEF3;',
            '&#xFEF4;',
            '&#xFEF2;',

            '&#xFE8C;',
            '&#xFE8B;',
            '&#xFEFC;',
            '&#xFEFB;' ];
            
            
svgdir = './fonts'
Fontdirs = os.listdir(svgdir)

# create new folder

for U in UArr:
    lablename = U[3:len(U)-1].lower()
    tempath = './labels/' + lablename
    if not os.path.exists(tempath):
        os.mkdir(tempath)
    else:
        pass
    

# rename png
for fontdir in Fontdirs:
    chardir = svgdir+'/'+fontdir
    charlist = os.listdir(chardir)
    
    for char in charlist:
        labelname = char.split(';')[0][3:len(char)].lower()
        new_name = labelname +'_'+ fontdir.split('.')[0].lower()+'.svg'
        print new_name
        os.rename(chardir+'/'+char,chardir+'/'+new_name)
        shutil.move(chardir+'/'+new_name,'./labels/'+labelname)

    print fontdir
    
    







