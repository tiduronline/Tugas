clear all;
clc;

X=[0 0;
   0 1;
   1 0;
   1 1]
 
T = [0;0;0;1]
W = [0 0];

alfa=0.2;
salah=1;
iterasi=0;
makiterasi=100;

while ((salah > 0) && (iterasi<=makiterasi))
  iterasi = iterasi + 1;
  salah=0;
  
  for i=1:4,
    Y(i)=0;
    for j=1:2,
      Y(i)=Y(i)+( X(i,j) * W(j) );
    end,
 

    if(Y(i) > 1.5)
      Y(i) = 1;
    else
      Y(i) = 0;
    end,
    salah=salah+abs(T(i)-Y(i));
  
    if(T(i)~=Y(i))
      W(:)=W(:)+alfa*T(i)+X(i,j);
    else
      W(:)=W(:);
    end,
    
  end,
end,

salah
W

