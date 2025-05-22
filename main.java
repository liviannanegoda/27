//Давайте начнем с создания класса flow://

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class flow implements Iterable<StudyGroup> {
    private List<StudyGroup> StudyGroup = new ArrayList<>();

    public void addgroup(StudyGroup group) {
        studyGroups.add(group);
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return studyGroups.iterator();
    }
}

//Далее создадим класс StreamComparator для сравнения потоков по количеству групп//

import java.util.Comparator;

public class StreamComparator implements Comparator<Flow> {
    @Override
    public int compare(Flow flow1, Flow flow2) {
        return Integer.compare(flow1.studyGroups.size(), flow2.studyGroups.size());
    }
}


//Теперь создадим класс FlowServiceПотокСервис, который добавит метод для сортировки списка потоков с использованием StreamComparator://
import java.util.Collections;
import java.util.List;

public class FlowService {
    public void sortStreams(List<Flow> streams) {
        Collections.sort(streams, new StreamComparator());
    }
}


//Модифицируем класс Controller, чтобы добавить созданный сервис и метод для сортировки списка потоков://

import java.util.List;

public class Controller {
    private FlowService potokService;

    public Controller(FlowService potokService) {
        this.potokService = potokService;
    }

    public void sortStreams(List<Flow> streams) {
        potokService.sortStreams(streams);
    }
}
