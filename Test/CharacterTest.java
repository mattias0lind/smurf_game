public class CharacterTest {
    @Test
    void empty_set_should_have_size_zero() {
        ARSet emptySet = new ARSet();
        assertEquals(0, emptySet.size());
    }

}
