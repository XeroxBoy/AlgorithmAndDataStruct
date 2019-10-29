select a.Id from  Weather as a join Weather as b on a.Temperature > b.Temperature and dateDiff(a.RecordDate,b.RecordDate) = 1
