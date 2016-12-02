### **svg2jpg**

Transfer svg file to png file

1. 使用`relabel.py`项目将fonts内的SVG文件按照字符分类, 将fonts文件夹导入字体, 新建labels文件夹

2. 使用`src\svg2png`将svg文件转为png文件, 文件保存在`./png2jpg/pngs`下面

3. 使用`png2jpg`将png文件转化为jpg文件, jpg文件保存在`./png2jpg/jpgs`下面