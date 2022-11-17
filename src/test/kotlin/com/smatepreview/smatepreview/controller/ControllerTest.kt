package com.smatepreview.smatepreview.controller

//@SpringBootTest
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//internal class ControllerTest(
//    private val restTemplate: RestTemplate, // (1)
//    private val restTemplateController: RestTemplateController, // (2)
//    private val apiService: ApiService,
//    private val apiRepository: ApiRepository,
//    private val api: Api
//) {
//
//    @Test
//    @DisplayName("Insert 된 사업자번호 조회 API Servcice  , getMethod")
//    fun getInfo() {
//
//        // GIVEN
//        val businessNumber = "TEST-BUSINESS-NUMBER"
//        val companyName = "TEST-COMPANY-NAME"
//
//        // WHEN
//        given(apiRepository.findAll())
//            apiRepository.willReturn(
//                api(
//                    1L,
//                    businessNumber,
//                    companyName,
//                    "",
//                    "",
//                    "",
//                    "",
//                    "",
//                    ""
//                )
//            )
//
//        // THEN
//        val saupEntity = apiService.saveData(businessNumber)
//        assertNotNull(saupEntity)
//        assertEquals(saupEntity.businessNumber, businessNumber)
//        assertEquals(saupEntity.companyName, companyName)
//
//    }
//
//}

//) {
//    private var server: MockRestServiceServer? = null
//
//    @BeforeEach
//    internal fun setUp() {
//        server = MockRestServiceServer.createServer(restTemplate) // (3)
//    }
//
//
//    @Test
//    internal fun `api test`() {
//        //given
//        val path = "/team-api-response.json"
//        val name = "team"
//        server
//            ?.expect(
//                requestTo("http://localhost:8080/")
//            )// (4)
//            ?.andExpect(method(HttpMethod.GET)) // (5)
//            ?.andRespond(
//                withStatus(HttpStatus.OK)
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(ClassPathResource(path, javaClass))
//            )// (6)
//
//        when
//        // (7)
//        val teams = restTemplateController.restTemplateTest()
//
//        then
//        // (8)
//        for (team in teams) {
//            println(team)
//
//        // (9)
//        then(teams).hasSize(10)
//        then(teams).anySatisfy {
//            then(it.name).startsWith("team")
//    }

//}
