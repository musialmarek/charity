package pl.coderslab.charity.institution;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.coderslab.charity.model.Institution;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


class InstitutionServiceTest {
    private InstitutionService testingObject;


    @Test
    public void shouldReturnListOfInstitutions() {
        //given
        List<Institution> institutionsMock = new ArrayList<>();
        InstitutionRepository institutionRepositoryMock = Mockito.mock(InstitutionRepository.class);
        Mockito.when(institutionRepositoryMock.findAll()).thenReturn(institutionsMock);
        testingObject = new InstitutionService(institutionRepositoryMock);
        //when
        List<Institution> all = testingObject.getAll();
        //then
        assertThat("shouldn't return null", all, CoreMatchers.notNullValue());
    }

}