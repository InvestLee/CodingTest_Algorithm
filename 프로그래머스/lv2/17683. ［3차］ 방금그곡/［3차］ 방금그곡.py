def solution(m, musicinfos):
    # C#, D#, F#, G#, A#을 한 글자로 치환
    m = m.replace('A#',"a").replace('G#',"g").replace('F#',"f").replace('D#',"d").replace('C#',"c")
    for i in range(len(musicinfos)):
        musicinfos[i] = musicinfos[i].replace('A#',"a").replace('G#',"g").replace('F#',"f").replace('D#',"d").replace('C#',"c")
    
    
    for i in range(len(musicinfos)):
        musicinfos[i] = musicinfos[i].split(',')
        
    #재생 시간
    for i in range(len(musicinfos)):
        musicinfos[i][0] = (int(musicinfos[i][1][:2])-int(musicinfos[i][0][:2]))*60+int(musicinfos[i][1][3:])-int(musicinfos[i][0][3:])
    musicinfos.sort(key= lambda x:x[0],reverse=True)
    
    #재생 시간 내 재생되는 음 리스트
    for i in range(len(musicinfos)):
        musicinfos[i][1] = ''
    for i in range(len(musicinfos)):
        for j in range(musicinfos[i][0]):
            musicinfos[i][1] += musicinfos[i][3][j%len(musicinfos[i][3])]
    
    print(musicinfos)
    
    #기억한 멜로디의 문자열이 재생된 곡을 포함하는 지 판별
    for i in range(len(musicinfos)):
        if m in musicinfos[i][1]:
            return musicinfos[i][2]
        
    return "(None)"