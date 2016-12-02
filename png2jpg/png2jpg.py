# -*- coding: utf-8 -*-
"""
Created on Tue Jun 21 14:56:51 2016

@author: Shang
"""
import os
from PIL import Image
# import numpy as np

# pngCongfig = "./pngs/"
pngCongfig = "./pngstd/"

pngDirs = os.listdir(pngCongfig)
jpgDirs = pngDirs
print "***Converting***\n"

for pngDirsNum in range(len(pngDirs)):
    pngPath = pngCongfig + pngDirs[pngDirsNum]
    
    pngName = os.listdir(pngPath)
    for pngNum in range(len(pngName)):
        pngFilePath = pngPath + "/" + pngName[pngNum]
        png = Image.open(pngFilePath)
        bg = Image.new("RGB", png.size, (255,255,255))
        bg.paste(png,png)

        #savePath = "./jpgs/"+jpgDirs[pngDirsNum]
        savePath = "./jpgstd/"+jpgDirs[pngDirsNum]

        if os.path.exists(savePath):
            bg.save(savePath + "/" + pngName[pngNum][:-5] +".jpg")
        else:
            os.makedirs(savePath)
            bg.save(savePath + "/" + pngName[pngNum][:-5] +".jpg")


print "------finished------\n"